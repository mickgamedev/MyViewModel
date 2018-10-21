package ru.yandex.dunaev.mick.myviewmodel.viewmodel;

import androidx.lifecycle.ViewModel;
import ru.yandex.dunaev.mick.myviewmodel.database.DatabaseHelper;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;
import ru.yandex.dunaev.mick.myviewmodel.util.PreferenceHelper;

public class MainViewModel extends ViewModel {
    public Model mModel = new Model();

    public MainViewModel(){
        DatabaseHelper.bindModelList();
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
