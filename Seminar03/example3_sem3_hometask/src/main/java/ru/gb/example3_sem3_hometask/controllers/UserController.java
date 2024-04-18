package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3_hometask.services.RegistrationService;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().save(user);
        return "User added from body!";
    }

    @PostMapping("/formdata")
    public String userAddFromFormData(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User added from form-data!";
    }

    @PostMapping("/param/{name}/{age}/{email}")
    public String userAddFromParam(@PathVariable(value = "name", required = true) String name, @PathVariable(value = "age", required = true) int age, @PathVariable(value = "email", required = true) String email)
    {
        service.processRegistration(name, age, email);
        return "User added from param!";
    }

}
