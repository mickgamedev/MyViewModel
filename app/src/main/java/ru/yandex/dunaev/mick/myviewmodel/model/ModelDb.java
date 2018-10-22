package ru.yandex.dunaev.mick.myviewmodel.model;

import java.util.UUID;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import ru.yandex.dunaev.mick.myviewmodel.adapter.UUIDconverter;

@Entity
public class ModelDb {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "uuid")
    @TypeConverters({UUIDconverter.class})
    public UUID uuid;

    public ModelDb(Model model){
        text = model.editText.get();
        uuid = model.uuid.get();
    }

    public ModelDb(){}
}
