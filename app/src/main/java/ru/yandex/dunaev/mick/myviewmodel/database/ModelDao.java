package ru.yandex.dunaev.mick.myviewmodel.database;

import java.util.List;
import java.util.UUID;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import io.reactivex.Observable;
import ru.yandex.dunaev.mick.myviewmodel.adapter.UUIDconverter;
import ru.yandex.dunaev.mick.myviewmodel.model.ModelDb;

@Dao
public interface ModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insetModel(ModelDb model);

    @Query("SELECT * FROM modeldb")
    Observable<List<ModelDb>> getModelsList();

    @TypeConverters({UUIDconverter.class})
    @Query("DELETE FROM modeldb WHERE uuid=:uuid")
    void deleteModel(UUID uuid);
}
