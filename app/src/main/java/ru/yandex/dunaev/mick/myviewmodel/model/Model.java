package ru.yandex.dunaev.mick.myviewmodel.model;

import java.util.UUID;

import androidx.databinding.ObservableField;

public class Model {
    public ObservableField<String> editText = new ObservableField<>();
    public ObservableField<UUID> uuid = new ObservableField<>(UUID.randomUUID());

    public Model(ModelDb modelDb){
        editText.set(modelDb.text);
        uuid.set(modelDb.uuid);
    }
    public Model(){}

    public void updateUUID(){
        uuid.set(UUID.randomUUID());
    }
    public void clearText(){
        editText.set("");
    }
}

