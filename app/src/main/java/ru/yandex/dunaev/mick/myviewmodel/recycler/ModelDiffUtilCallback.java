package ru.yandex.dunaev.mick.myviewmodel.recycler;

import java.util.List;
import java.util.UUID;

import androidx.recyclerview.widget.DiffUtil;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;

public class ModelDiffUtilCallback extends DiffUtil.Callback {
    private List<Model> oldList;
    private List<Model> newList;

    public ModelDiffUtilCallback(List<Model> oldList, List<Model> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Model newModel = newList.get(newItemPosition);
        Model oldModel = oldList.get(oldItemPosition);

        UUID newId = newModel.uuid.get();
        UUID oldId = oldModel.uuid.get();

        return oldId.equals(newId);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Model newModel = newList.get(newItemPosition);
        Model oldModel = oldList.get(oldItemPosition);

        String newText = newModel.editText.get();
        String oldText = oldModel.editText.get();

        return newText.equals(oldText);
    }
}
