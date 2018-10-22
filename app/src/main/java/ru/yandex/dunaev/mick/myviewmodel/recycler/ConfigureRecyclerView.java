package ru.yandex.dunaev.mick.myviewmodel.recycler;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.yandex.dunaev.mick.myviewmodel.model.Model;
import ru.yandex.dunaev.mick.myviewmodel.model.ModelData;

public class ConfigureRecyclerView {

    public interface OnItemSwipeListener {
        void onItemSwiped(int position);
    }

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

    @BindingAdapter("app:swipe_action")
    public static void bindModelSwipe(RecyclerView recycler, OnItemSwipeListener listener){
        if(recycler.getAdapter() == null) configRecycler(recycler);
        ItemTouchHelper.SimpleCallback callback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int swipeIndex = viewHolder.getAdapterPosition();
                listener.onItemSwiped(swipeIndex);
            }
        };
        new ItemTouchHelper(callback).attachToRecyclerView(recycler);
    }

}
