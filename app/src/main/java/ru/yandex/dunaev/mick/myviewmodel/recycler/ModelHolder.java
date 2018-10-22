package ru.yandex.dunaev.mick.myviewmodel.recycler;

import androidx.recyclerview.widget.RecyclerView;
import ru.yandex.dunaev.mick.myviewmodel.databinding.CardModelBinding;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;

public class ModelHolder extends RecyclerView.ViewHolder {

    private CardModelBinding binding;

    public ModelHolder(CardModelBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Model model){
        binding.setModel(model);
        binding.executePendingBindings();
    }
}
