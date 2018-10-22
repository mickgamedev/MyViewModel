package ru.yandex.dunaev.mick.myviewmodel.viewmodel;

import java.util.LinkedList;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import ru.yandex.dunaev.mick.myviewmodel.database.DatabaseHelper;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;
import ru.yandex.dunaev.mick.myviewmodel.recycler.ModelData;
import ru.yandex.dunaev.mick.myviewmodel.util.PreferenceHelper;

public class MainViewModel extends ViewModel {
    public Model mModel = new Model();
    public ObservableField<ModelData> modelData = new ObservableField<>(new ModelData(new LinkedList<>(),null));

    public MainViewModel(){
        DatabaseHelper.bindModelList(modelData);
        PreferenceHelper.load(mModel);
    }

    public void addToDatabase(){
        DatabaseHelper.insert(mModel);
    }

    @Override
    protected void onCleared() {
        PreferenceHelper.save(mModel);
    }
}
