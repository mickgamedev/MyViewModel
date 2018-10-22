package ru.yandex.dunaev.mick.myviewmodel.adapter;

import java.util.UUID;

import androidx.databinding.BindingConversion;
import androidx.databinding.ObservableField;
import androidx.room.TypeConverter;

public class UUIDconverter {
    @TypeConverter
    public String UUIDtoString(UUID uuid) {
        return uuid.toString();
    }
    @TypeConverter
    public UUID StringToUUID(String st){
        return UUID.fromString(st);
    }

    @BindingConversion
    public static String UUIDtoString(ObservableField<UUID> uuid){
        return uuid.get().toString();
    }
}
