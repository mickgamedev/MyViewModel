package ru.yandex.dunaev.mick.myviewmodel.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import ru.yandex.dunaev.mick.myviewmodel.R;
import ru.yandex.dunaev.mick.myviewmodel.databinding.FragmentInputBinding;
import ru.yandex.dunaev.mick.myviewmodel.viewmodel.MainViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {


    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentInputBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_input, container, false);
        MainViewModel mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        return binding.getRoot();
    }

}
