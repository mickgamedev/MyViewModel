package ru.yandex.dunaev.mick.myviewmodel.database;

import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.room.Room;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;

public class DatabaseHelper {
    private DatabaseHelper() {
    }

    private static AppDatabase db;

    public static void init(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "view-database").build();
    }

    public static void insert(Model model) {
        Completable.fromCallable(() -> insertAsync(model)).subscribeOn(Schedulers.io()).subscribe();
    }

    private static Void insertAsync(Model model) {
        ModelDb modelDb = new ModelDb();
        modelDb.text = model.editText.get();
        db.modelDao().insetModel(modelDb);
        return null;
    }

    private static Disposable bindList;

    public static void bindModelList() {
        if(bindList != null && !bindList.isDisposed()) bindList.dispose();
        bindList = db.modelDao().getModelsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> processModelsList(list));
    }

    private static void processModelsList(List<ModelDb> list) {
        Log.v("DatabaseHelper", "Receved new list");
    }
}
