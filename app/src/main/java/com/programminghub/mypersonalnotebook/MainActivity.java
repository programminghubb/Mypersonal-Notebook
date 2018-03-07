package com.programminghub.mypersonalnotebook;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
=======
=======
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView showNotesList;
    FloatingActionButton addNotes;
    NoteDatabase noteDatabase;
    NoteAdapter noteAdapter;
    TextView showNoOfNotes;
<<<<<<< HEAD
=======
=======

public class MainActivity extends AppCompatActivity {

>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
        initView();
        defineView();
        bindView();
        addClickListeners();


    }

    private void initView(){
        noteDatabase=NoteDatabase.getAppDatabase(this);

    }
    private void defineView(){
        addNotes= (FloatingActionButton) findViewById(R.id.fab);
        showNotesList=(RecyclerView) findViewById(R.id.show_notes_list);
        showNoOfNotes=findViewById(R.id.show_no_of_notes);

    }
    private void bindView(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        showNotesList.setLayoutManager(layoutManager);

        showNoOfNotes.setText(String.valueOf(noteDatabase.newNoteDAO().getTotalNoteCount()));

       noteAdapter=new NoteAdapter(noteDatabase.newNoteDAO().getAllNote(), new NoteAdapter.OnNoteLongPressedListener() {
<<<<<<< HEAD
           @Override
           public void onNoteLongPressed(Note note) {

               showDeleteNoteDialog(note);
           }
       }, new NoteAdapter.onNotePressedListener() {
           @Override
           public void onNotePressedListener(Note note) {
               Intent notePressedIntent=new Intent(MainActivity.this,NoteDetailActivity.class);
               notePressedIntent.putExtra(NoteDetailActivity.KEY_NOTE_DETAIL_INTENT,note);
               startActivity(notePressedIntent);
           }
       });
=======
            @Override
            public void onNoteLongPressed(Note note) {

                showDeleteNoteDialog(note);
            }
        });
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
        showNotesList.setAdapter(noteAdapter);
    }
    private void addClickListeners(){
        addNotes.setOnClickListener(new View.OnClickListener() {
<<<<<<< HEAD
            @Override
            public void onClick(View view) {
                Intent addNoteIntent=new Intent(MainActivity.this,AddNotesActivity.class);
                addNoteIntent.putExtra(AddNotesActivity.KEY_IS_UPDATE,false);
=======
=======

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
            @Override
            public void onClick(View view) {
                Intent addNoteIntent=new Intent(MainActivity.this,AddNotesActivity.class);
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
                startActivity(addNoteIntent);
            }
        });
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72


    private void showDeleteNoteDialog(final Note note){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this note?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        noteDatabase.newNoteDAO().deleteNote(note);
                        noteAdapter.deleteNote(note);
                        showNoOfNotes.setText(String.valueOf(noteDatabase.newNoteDAO().getTotalNoteCount()));
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


<<<<<<< HEAD
=======


=======
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
>>>>>>> 9695cc8263d74d160e755345df6ac718d2ea7b8d
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
}
