package ru.gb.hw_sem6_base.repository;
import org.springframework.stereotype.Repository;
import ru.gb.hw_sem6_base.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
}