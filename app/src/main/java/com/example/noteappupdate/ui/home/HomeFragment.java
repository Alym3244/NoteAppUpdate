package com.example.noteappupdate.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.noteappupdate.databinding.FragmentHomeBinding;
import com.example.noteappupdate.models.NoteModel;
import com.example.noteappupdate.ui.adapters.NoteAdapter;

import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;
import java.util.List;


import static com.example.noteappupdate.NoteFragment.BUNDLE_KEY;
import static com.example.noteappupdate.NoteFragment.REQUEST_KEY;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private NoteModel model;
    private NoteAdapter adapter = new NoteAdapter();
    private List<NoteModel> list = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();
        getDataFromNoteFragment();
    }

    private void getDataFromNoteFragment() {
        getParentFragmentManager().setFragmentResultListener(REQUEST_KEY, getViewLifecycleOwner(), (requestKey, result) -> {
            model = (NoteModel) result.getSerializable(BUNDLE_KEY);
            adapter.addModel(model);
            adapter.addList(list);
            Log.e("aboba", "getDataFromNoteFragment: " + model);
        });

    }


    private void setupRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.rv.setLayoutManager(linearLayoutManager);
        binding.rv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}