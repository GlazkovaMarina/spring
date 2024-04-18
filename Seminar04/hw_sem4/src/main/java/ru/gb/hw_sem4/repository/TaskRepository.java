package ru.gb.hw_sem4.repository;


import ru.gb.hw_sem4.domain.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@AllArgsConstructor
public class TaskRepository {


    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }
    public List<Task> addTask(Task task){
        tasks.add(task);
        return tasks;
    }


}
