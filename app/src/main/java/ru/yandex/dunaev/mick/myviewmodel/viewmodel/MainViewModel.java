package ru.yandex.dunaev.mick.myviewmodel.viewmodel;

import android.util.Log;

import java.util.LinkedList;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import ru.yandex.dunaev.mick.myviewmodel.database.DatabaseHelper;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;
import ru.yandex.dunaev.mick.myviewmodel.model.ModelData;
import ru.yandex.dunaev.mick.myviewmodel.util.PreferenceHelper;

public class MainViewModel extends ViewModel{
    public Model mModel = new Model();
    public ObservableField<ModelData> modelData = new ObservableField<>(new ModelData(new LinkedList<>(),null));

    public MainViewModel(){
        DatabaseHelper.bindModelList(modelData);
        PreferenceHelper.load(mModel);
    }

    public void addToDatabase(){
        DatabaseHelper.insert(mModel);
        mModel.updateUUID();
        mModel.clearText();
    }

    public void deleteFromDatabase(int position) {
        Model model = modelData.get().getModel(position);
        DatabaseHelper.delete(model);
    }

    @Override
    protected void onCleared() {
        PreferenceHelper.save(mModel);
    }

}
