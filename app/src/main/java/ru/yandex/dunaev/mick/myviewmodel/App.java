package ru.yandex.dunaev.mick.myviewmodel;

import android.app.Application;

import ru.yandex.dunaev.mick.myviewmodel.database.DatabaseHelper;
import ru.yandex.dunaev.mick.myviewmodel.util.PreferenceHelper;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.init(getApplicationContext());
        PreferenceHelper.init(getApplicationContext());
    }
}
