package com.programminghub.mypersonalnotebook;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
<<<<<<< HEAD
import android.content.Intent;
=======
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72

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

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
    @Query("SELECT * FROM note WHERE noteCategory LIKE :noteCategory")
    public List<Note> findNoteAsPerCategory(String noteCategory);

    @Query("Select COUNT(note) from note")
    public Integer getTotalNoteCount();


<<<<<<< HEAD
    @Query("Select * from note where noteId LIKE :noteId")
    public Note getNoteAsPerId(Integer noteId);


=======
=======
>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
}
