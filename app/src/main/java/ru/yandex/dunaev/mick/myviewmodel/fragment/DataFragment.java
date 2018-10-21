package ru.yandex.dunaev.mick.myviewmodel.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import ru.yandex.dunaev.mick.myviewmodel.R;
import ru.yandex.dunaev.mick.myviewmodel.databinding.FragmentDataBinding;
import ru.yandex.dunaev.mick.myviewmodel.viewmodel.MainViewModel;


public class DataFragment extends Fragment {

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDataBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_data, container, false);
        MainViewModel mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        return binding.getRoot();
    }

}
