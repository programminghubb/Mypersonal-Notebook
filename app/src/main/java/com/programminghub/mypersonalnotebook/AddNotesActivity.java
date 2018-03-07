package com.programminghub.mypersonalnotebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddNotesActivity extends AppCompatActivity {

    EditText noteTitleEt,noteEt;
    Spinner noteCategorySpnr;
    Button addNote;
    NoteDatabase noteDatabase;
    Toolbar toolbar;
    private final String TAG=AddNotesActivity.class.getSimpleName();

    public static final String KEY_IS_UPDATE="isUpdate";
    Boolean isUpdate;
    Integer noteId;
    public static final String KEY_NOTE_ID="noteId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);


        if(getIntent().hasExtra(KEY_IS_UPDATE)){
            isUpdate=getIntent().getExtras().getBoolean(KEY_IS_UPDATE);
            if(isUpdate){
                noteId=getIntent().getExtras().getInt(KEY_NOTE_ID);
            }
        }
        initView();
        defineView();
        bindView();
        addClickListener();

    }

    private void initView(){
        noteDatabase=NoteDatabase.getAppDatabase(this);
    }

    //definig views
    private void defineView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        noteTitleEt=findViewById(R.id.note_title);
        noteEt=findViewById(R.id.note);
        noteCategorySpnr=findViewById(R.id.note_category);
        addNote=findViewById(R.id.add_note);


    }
    private void bindView(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getSupportActionBar().setTitle("Add Note :)");

        if(isUpdate) {
            addNote.setText("Update");
            getSupportActionBar().setTitle("Update");
            Note note=noteDatabase.newNoteDAO().getNoteAsPerId(noteId);
            noteTitleEt.setText(note.getNoteTitle());
            noteEt.setText(note.getNote());
            String categoryList[]=getResources().getStringArray(R.array.note_category);
            List list = Arrays.asList(categoryList);
            noteCategorySpnr.setSelection(list.indexOf(note.getNoteCategory()));
        }
    }
    //handling all the click function in a single funcition
    private void addClickListener(){
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    Long time=System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Note note=new Note(noteTitle, noteCategory, sdf.format(time), noteStr);
                    if(isUpdate){
                        note.setNoteId(noteId);
                        Log.d(TAG,"note id is:"+note.getNoteId());
                        Log.d(TAG,"note title is:"+noteTitle);
                        Log.d(TAG,"note is:"+noteStr);
                        Log.d(TAG,"note category is:"+noteCategory);
                        Log.d(TAG,"inside note update");
                        noteDatabase.newNoteDAO().updateNote(note);
                        Log.d(TAG,"note updated succesfully");

                    }else {
                        Log.d(TAG,"inside adding note");
                        noteDatabase.newNoteDAO().insertNote(note);
                    }
                    Intent navigateToMain=new Intent(AddNotesActivity.this,MainActivity.class);
                    startActivity(navigateToMain);
                }

            }
        });


        noteCategorySpnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                noteCategory=noteCategorySpnr.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //to check whether the note is added succesfully or not
    private void noteAddedSuccesfulOrNot(){
        List<Note> notes=noteDatabase.newNoteDAO().getAllNote();
        if(notes.size()>0){
            for (int i=0;i<notes.size();i++){
                Log.d(TAG,"note you aadded to daatabase is:"+notes.get(i).getNote());
            }
        }
    }

    String noteCategory,noteStr,noteTitle;
    //to validate if null data is added in the database or not
    private boolean validate(){
        boolean valid=false;
        noteStr=noteEt.getText().toString();
        noteTitle=noteTitleEt.getText().toString();
        if(TextUtils.isEmpty(noteTitle))
            noteTitleEt.setError("Required");
        else if(TextUtils.isEmpty(noteStr))
            noteEt.setError("Required");
        else
            valid=true;
        return valid;
    }

}
