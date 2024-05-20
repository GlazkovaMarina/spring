package ru.gb.hw_sem6_base;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.gb.hw_sem6_base.service.impl.NoteServiceImpl;
import ru.gb.hw_sem6_base.repository.NoteRepository;
import ru.gb.hw_sem6_base.domain.Note;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import java.util.Optional;
import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationUTest {
    @InjectMocks
    private  NoteServiceImpl noteServiceImpl;
    @Mock
    private NoteRepository noteRepository;
    @Test
    public void correctFindById(){
        Note note = new Note();
        note.setId(1L);
        note.setTitle("First homework");
        note.setContents("to do homework");

        given(noteRepository.findById(note.getId())).willReturn(Optional.of(note));

        noteServiceImpl.getNoteById(1L);

        verify(noteRepository).findById(1L);
    }

}
