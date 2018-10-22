package ru.yandex.dunaev.mick.myviewmodel.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import ru.yandex.dunaev.mick.myviewmodel.R;
import ru.yandex.dunaev.mick.myviewmodel.databinding.CardModelBinding;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;

public class ModelAdapter extends RecyclerView.Adapter<ModelHolder> {

    private List<Model> models = new LinkedList<>();

    public void setModels(List<Model> models){
        this.models.clear();
        this.models.addAll(models);
    }

    @NonNull
    @Override
    public ModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardModelBinding binding = DataBindingUtil.inflate(inflater, R.layout.card_model, parent, false);
        return new ModelHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelHolder holder, int position) {
        holder.bind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
