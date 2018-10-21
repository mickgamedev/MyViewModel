package ru.yandex.dunaev.mick.myviewmodel.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Observable;

@Dao
public interface ModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insetModel(ModelDb model);

    @Query("SELECT * FROM modeldb")
    Observable<List<ModelDb>> getModelsList();
}
