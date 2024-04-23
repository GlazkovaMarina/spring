package ru.gb.base_hw_sem6.repository;
import org.springframework.stereotype.Repository;
import ru.gb.base_hw_sem6.domain.Note;
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    
}