package ru.yandex.dunaev.mick.myviewmodel.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ModelDb.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ModelDao modelDao();
}
