package ru.gb.my_first_crud.controller;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.my_first_crud.model.User;
import ru.gb.my_first_crud.service.UserService;
import lombok.AllArgsConstructor;

import java.util.List;
@Log
@AllArgsConstructor
@Controller
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        log.severe("GET findAll()");
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){

        log.severe("GET createUserForm()");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        log.severe("POST createUser()");
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        log.severe("GET deleteUser()");
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(User user){
        log.severe("GET updateUserForm()");
        return "user-update";
    }

    @PostMapping("/user-update/{id}")
    public String updateUser(User user){
        log.severe("POST updateUser()");
        userService.updateUser(user);
        return "redirect:/users";
    }
}
