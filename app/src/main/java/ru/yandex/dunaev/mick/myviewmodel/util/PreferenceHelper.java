package ru.yandex.dunaev.mick.myviewmodel.util;

import android.content.Context;
import android.content.SharedPreferences;

import ru.yandex.dunaev.mick.myviewmodel.model.Model;

public class PreferenceHelper {
    private PreferenceHelper(){}

    private static SharedPreferences settings;

    public static void init(Context context){
        settings = context.getSharedPreferences("settings.txt", Context.MODE_PRIVATE);
    }

    public static void save(Model model){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("text",model.editText.get());
        editor.apply();
    }

    public static void load(Model model){
        model.editText.set(settings.getString("text",""));
    }

}
