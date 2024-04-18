package ru.gb.hw_sem4.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.hw_sem4.domain.Task;
import ru.gb.hw_sem4.repository.TaskRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public List<Task> getTasks(){
        return taskRepository.getTasks();
    }

    public List<Task> addTask(Task task){
        return taskRepository.addTask(task);
    }

//    public void deleteById(int id) {
//        userRepository.deleteById(id);
//    }
//    public void updateUser(User user){
//        userRepository.updateUser(user);
//    }
}
