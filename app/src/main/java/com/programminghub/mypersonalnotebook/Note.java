package com.programminghub.mypersonalnotebook;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

<<<<<<< HEAD
import java.io.Serializable;

=======
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
/**
 * Created by rojin on 3/4/2018.
 */

@Entity
<<<<<<< HEAD
public class Note implements Serializable{
=======
public class Note {
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72

    @PrimaryKey
    private Integer noteId;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    @ColumnInfo
    private String noteTitle;

    @ColumnInfo(name = "noteCategory")
    private String noteCategory;

    @ColumnInfo
    private String noteTime;

    @ColumnInfo
    private String note;


    public Note(String noteTitle, String noteCategory, String noteTime, String note) {
        this.noteTitle = noteTitle;
        this.noteCategory = noteCategory;
        this.noteTime = noteTime;
        this.note = note;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(String noteCategory) {
        this.noteCategory = noteCategory;
    }

    public String getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(String noteTime) {
        this.noteTime = noteTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
