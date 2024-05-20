package ru.gb.hw_sem6_base;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.hw_sem6_base.service.impl.NoteServiceImpl;
import ru.gb.hw_sem6_base.repository.NoteRepository;
import ru.gb.hw_sem6_base.domain.Note;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TestServiceWithAnnotationIntegration {
    @Autowired
    private  NoteServiceImpl noteServiceImpl;
    @MockBean
    private NoteRepository noteRepository;
    @Test
    public void correctFindById(){
        Note note = new Note();
        note.setId(1L);
        note.setTitle("First homework");
        note.setContents("to do homework");

        when(noteRepository.findById(note.getId())).thenReturn(Optional.of(note));

        noteServiceImpl.getNoteById(1L);

        verify(noteRepository).findById(1L);
    }

}

