package com.programminghub.mypersonalnotebook;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.content.Intent;

import java.util.List;

/**
 * Created by rojin on 3/4/2018.
 */

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("Select * from note")
    List<Note> getAllNote();

    @Query("SELECT * FROM note WHERE noteCategory LIKE :noteCategory")
    public List<Note> findNoteAsPerCategory(String noteCategory);

    @Query("Select COUNT(note) from note")
    public Integer getTotalNoteCount();


}
