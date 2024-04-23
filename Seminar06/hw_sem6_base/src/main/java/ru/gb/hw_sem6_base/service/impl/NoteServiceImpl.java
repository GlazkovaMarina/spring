package ru.gb.hw_sem6_base.service.impl;

import ru.gb.hw_sem6_base.repository.NoteRepository;
import ru.gb.hw_sem6_base.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.hw_sem6_base.domain.Note;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Note updateNote(Note note) {
        Note noteById = getNoteById(note.getId());

        noteById.setTitle(note.getTitle());
        noteById.setContents(note.getContents());
        noteById.setLocalDateTime(note.getLocalDateTime());
        return noteRepository.save(noteById);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note noteById = getNoteById(id);
        noteRepository.delete(noteById);
    }
}
