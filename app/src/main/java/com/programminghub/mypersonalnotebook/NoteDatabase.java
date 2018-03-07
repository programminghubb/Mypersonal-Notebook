package com.programminghub.mypersonalnotebook;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by rojin on 3/4/2018.
 */

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase INSTANCE;

<<<<<<< HEAD
    public abstract NoteDao newNoteDAO();
=======
<<<<<<< HEAD
    public abstract NoteDao newNoteDAO();
=======
    public abstract NoteDao newChatDAO();
>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72

    public static NoteDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }

}



