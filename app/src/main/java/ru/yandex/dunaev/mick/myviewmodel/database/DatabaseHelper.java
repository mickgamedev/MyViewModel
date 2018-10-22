package ru.yandex.dunaev.mick.myviewmodel.database;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Room;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;
import ru.yandex.dunaev.mick.myviewmodel.model.ModelData;
import ru.yandex.dunaev.mick.myviewmodel.model.ModelDb;
import ru.yandex.dunaev.mick.myviewmodel.recycler.ModelDiffUtilCallback;

public class DatabaseHelper {
    private DatabaseHelper() {
    }

    private static AppDatabase db;

    public static void init(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "view-database").build();
    }

    public static void insert(Model model) {
        ModelDb modelDb = new ModelDb(model);
        Completable.fromCallable(() -> insertAsync(modelDb)).subscribeOn(Schedulers.io()).subscribe();
    }

    private static Void insertAsync(ModelDb modelDb) {
        db.modelDao().insetModel(modelDb);
        return null;
    }

    public static void delete(Model model){
        ModelDb modelDb = new ModelDb(model);
        Completable.fromCallable(() -> deleteAsync(modelDb.uuid)).subscribeOn(Schedulers.io()).subscribe();
    }

    private static Void deleteAsync(UUID uuid){
        db.modelDao().deleteModel(uuid);
        return null;
    }

    private static Disposable bindList;

    private static List<Model> fromModelDbList(List<ModelDb> modelDbs){
        List<Model> models = new LinkedList<>();
        for(ModelDb modelDb : modelDbs) models.add(new Model(modelDb));
        return  models;
    }

    private static Observable<ModelData> createModelData(List<Model> oldList, List<ModelDb> newListDb){
        List<Model> newList = fromModelDbList(newListDb);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new ModelDiffUtilCallback(oldList,newList));
        return Observable.just(new ModelData(newList,result));
    }

    public static void bindModelList(ObservableField<ModelData> data) {
        if(bindList != null && !bindList.isDisposed()) bindList.dispose();
        bindList = db.modelDao().getModelsList()
                .flatMap(v -> createModelData(data.get().getList(),v))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(v -> data.set(v));
    }
}
