package com.programminghub.mypersonalnotebook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rojin on 3/5/2018.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{

    List<Note> noteList;
    OnNoteLongPressedListener onNoteLongPressedListener;
<<<<<<< HEAD
    onNotePressedListener onNotePressedListener;

    public NoteAdapter(List<Note> noteList,OnNoteLongPressedListener onNoteLongPressedListener,onNotePressedListener onNotePressedListener) {
        this.noteList = noteList;
        this.onNoteLongPressedListener=onNoteLongPressedListener;
        this.onNotePressedListener=onNotePressedListener;
=======

    public NoteAdapter(List<Note> noteList,OnNoteLongPressedListener onNoteLongPressedListener) {
        this.noteList = noteList;
        this.onNoteLongPressedListener=onNoteLongPressedListener;
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(noteList.get(position));

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public void deleteNote(Note note){
        noteList.remove(note);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView noteTv,noteTitleTv,noteCategoryTv,noteDateTv;

        public ViewHolder(View itemView) {
            super(itemView);
            noteTv=itemView.findViewById(R.id.show_note);
            noteTitleTv=itemView.findViewById(R.id.show_note_title);
            noteCategoryTv=itemView.findViewById(R.id.show_note_category);
            noteDateTv=itemView.findViewById(R.id.show_note_date);
        }

        public void bindView(final Note note){
<<<<<<< HEAD
            noteTv.setMaxLines(2);
=======
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
            noteTv.setText(note.getNote());
            noteTitleTv.setText(note.getNoteTitle());
            noteCategoryTv.setText(note.getNoteCategory());
            noteDateTv.setText(note.getNoteTime());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onNoteLongPressedListener.onNoteLongPressed(note);
                    return false;
                }
            });

<<<<<<< HEAD
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNotePressedListener.onNotePressedListener(note);
                }
            });

=======
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
        }
    }

    interface OnNoteLongPressedListener{
        void onNoteLongPressed(Note note);
    }
<<<<<<< HEAD

    interface onNotePressedListener{
        void onNotePressedListener(Note note);
    }
=======
>>>>>>> 95bf8a3ff4b2f8b8082824c1d8a1244e30188f72
}
