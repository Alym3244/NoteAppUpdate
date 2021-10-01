package com.example.noteappupdate.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteappupdate.databinding.ItemNoteBinding;
import com.example.noteappupdate.models.NoteModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<NoteModel> list = new ArrayList<>();

    public void addModel(NoteModel model) {
        list.add(model);
        notifyDataSetChanged();
    }

    public void addList(List<NoteModel> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }//я хочу пиццы

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoteViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        private final ItemNoteBinding binding;

        public NoteViewHolder(ItemNoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(NoteModel noteModel) {
            binding.itemTitle.setText(noteModel.getTitle());
        }
    }
}
