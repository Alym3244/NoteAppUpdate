package com.example.noteappupdate.models;

import java.io.Serializable;

public class NoteModel implements Serializable {
    private String title;

    public NoteModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
