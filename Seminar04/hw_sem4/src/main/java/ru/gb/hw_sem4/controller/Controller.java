package ru.gb.hw_sem4.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.hw_sem4.domain.Task;
import ru.gb.hw_sem4.service.TaskService;
import java.util.List;
@AllArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {
    TaskService taskService;
    @RequestMapping("/home")
    public String getHome(){
        return "home.html";
    }
    @RequestMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks",taskService.getTasks());
        return "tasks.html";
    }
    @PostMapping("/create")
    public String addTask(Task task){
        taskService.addTask(task);
        return "redirect:/tasks";
    }
    @GetMapping("/create")
    public String getCreateForm(Task task){
        return "create.html";
    }

}
