package com.shihan.noteapplication.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.shihan.noteapplication.data.NotesDateSource
import com.shihan.noteapplication.model.Note

class NoteViewModel:ViewModel() {
    private var noteList = mutableStateListOf<Note>()
    
    init {
        noteList.addAll(NotesDateSource().loadNotes())
    }
    
    fun addNote(note: Note){
        noteList.add(note)
    }
    
    fun removeNote (note: Note){
        noteList.remove(note)
    }
    
    fun getAllNotes():List<Note>{
        return noteList
    }
}