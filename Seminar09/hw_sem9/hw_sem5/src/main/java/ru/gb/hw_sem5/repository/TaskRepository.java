package ru.gb.hw_sem5.repository;

import ru.gb.hw_sem5.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.hw_sem5.domain.TaskStatus;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    public List<Task> findByTaskStatus(TaskStatus taskStatus);
}
