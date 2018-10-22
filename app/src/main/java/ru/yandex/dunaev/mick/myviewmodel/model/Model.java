package ru.yandex.dunaev.mick.myviewmodel.model;

import androidx.databinding.ObservableField;
import ru.yandex.dunaev.mick.myviewmodel.database.ModelDb;

public class Model {
    public ObservableField<String> editText = new ObservableField<>();
    public Model(ModelDb modelDb){
        editText.set(modelDb.text);
    }
    public Model(){}
}

