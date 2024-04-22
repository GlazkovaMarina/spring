package ru.gb.hw_sem5.controller;

import ru.gb.hw_sem5.domain.Task;
import ru.gb.hw_sem5.service.TaskService;
import ru.gb.hw_sem5.domain.TaskStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@AllArgsConstructor
@RestController // не будет представления, чисто API
public class TaskController {
    private TaskService taskService;
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return "Задача " + id + " удалена!";
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByTaskStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByTaskStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status){
        return taskService.updateTaskStatus(id, status);
    }

}
