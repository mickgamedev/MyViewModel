package ru.yandex.dunaev.mick.myviewmodel.recycler;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ConfigureRecyclerView {

    private static void configRecycler(RecyclerView recycler){
        recycler.setAdapter(new ModelAdapter());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recycler.getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recycler.setLayoutManager(linearLayoutManager);
    }

    @BindingAdapter("app:model_data")
    public static void bindModelData(RecyclerView recycler, ModelData data){
        if(recycler.getAdapter() == null) configRecycler(recycler);

        ModelAdapter adapter = (ModelAdapter) recycler.getAdapter();
        adapter.setModels(data.getList());

        DiffUtil.DiffResult result = data.getDiffResult();
        if(result != null) result.dispatchUpdatesTo(adapter);
    }



}
