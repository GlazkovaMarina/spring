package ru.gb.hw_sem5.service;
import org.springframework.stereotype.Service;
import ru.gb.hw_sem5.domain.Task;
import ru.gb.hw_sem5.domain.TaskStatus;
import ru.gb.hw_sem5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import java.util.List;
@AllArgsConstructor
@Service
public class TaskService {
    private TaskRepository taskRepository;
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }
    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public List<Task> getTasksByTaskStatus(TaskStatus taskStatus){
        return taskRepository.findByTaskStatus(taskStatus);
    }
    public Task updateTaskStatus(Long id, TaskStatus taskStatus){
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setTaskStatus(taskStatus); // устанавливаем новый статус
            taskRepository.save(task); // обновляем данные в таблице
        }
        return task;
    }


}
