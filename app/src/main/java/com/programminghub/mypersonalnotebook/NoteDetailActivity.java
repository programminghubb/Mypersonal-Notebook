package com.programminghub.mypersonalnotebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class NoteDetailActivity extends AppCompatActivity {
public static final String KEY_NOTE_DETAIL_INTENT="noteDetail";
Note note;
    
TextView noteTitleTv,noteCategoryTv,noteDateTv,noteTv;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        note= (Note) getIntent().getSerializableExtra(KEY_NOTE_DETAIL_INTENT);

        defineView();
        bindView();
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editNoteIntent=new Intent(NoteDetailActivity.this,AddNotesActivity.class);
                editNoteIntent.putExtra(AddNotesActivity.KEY_IS_UPDATE,true);
                editNoteIntent.putExtra(AddNotesActivity.KEY_NOTE_ID,note.getNoteId());
                startActivity(editNoteIntent);
            }
        });
    }
    
    private void defineView(){
        noteTv=findViewById(R.id.show_note);
        noteTitleTv=findViewById(R.id.show_note_title);
        noteCategoryTv=findViewById(R.id.show_note_category);
        noteDateTv=findViewById(R.id.show_note_date);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void bindView(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        noteTv.setText(note.getNote());
        noteTitleTv.setText(note.getNoteTitle());
        noteCategoryTv.setText(note.getNoteCategory());
        noteDateTv.setText(note.getNoteTime());
    }

}
