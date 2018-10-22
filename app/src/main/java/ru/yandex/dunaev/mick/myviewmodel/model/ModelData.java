package ru.yandex.dunaev.mick.myviewmodel.model;

import android.view.View;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;

public class ModelData {
    private List<Model> list;
    private DiffUtil.DiffResult diffResult;

    public ModelData(List<Model> list, DiffUtil.DiffResult diffResult) {
        this.list = list;
        this.diffResult = diffResult;
    }

    public List<Model> getList() {
        return list;
    }

    public DiffUtil.DiffResult getDiffResult() {
        return diffResult;
    }
    public Model getModel(int position) {return list.get(position);}
}
