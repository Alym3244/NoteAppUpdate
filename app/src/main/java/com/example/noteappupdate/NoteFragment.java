package com.example.noteappupdate;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.noteappupdate.databinding.FragmentNoteBinding;
import com.example.noteappupdate.models.NoteModel;

import org.jetbrains.annotations.NotNull;


public class NoteFragment extends Fragment {
    public static final String BUNDLE_KEY = "title";
    public static final String REQUEST_KEY = "sss";
    EditText etTitle;
    Button btnBack;
    NoteModel model;
    private FragmentNoteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        click();
    }

    private void click() {
        binding.btnBack.setOnClickListener(v -> {
            String text = binding.etTitle.getText().toString().trim();
            Bundle bundle = new Bundle();
            model = new NoteModel(text);
            bundle.putSerializable(BUNDLE_KEY, model);
            getParentFragmentManager().setFragmentResult(REQUEST_KEY, bundle);
            Log.e("amogus", "click: "+ model );
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                    .navigateUp();
        });
    }
}