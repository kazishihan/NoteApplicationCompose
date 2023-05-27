package com.shihan.noteapplication.data

import com.shihan.noteapplication.model.Note

class NotesDateSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", descriptor = "This is a very good day "),
            Note(title = "A good day", descriptor = "This is a very good day "),
            Note(title = "A good day", descriptor = "This is a very good day "),
            Note(title = "A good day", descriptor = "This is a very good day "),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
            Note(title = "Movie day", descriptor = "watching movie with full family"),
        )
        
    }
}