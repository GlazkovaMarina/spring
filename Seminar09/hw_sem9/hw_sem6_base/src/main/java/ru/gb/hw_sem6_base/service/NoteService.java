package ru.gb.hw_sem6_base.service;

import ru.gb.hw_sem6_base.domain.Note;

import java.util.List;

public interface NoteService {
    Note createNote(Note note);
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Note note);
    void deleteNote(Long id);
}
