package ru.gb.hw_sem7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.hw_sem7.service.HwService;
import ru.gb.hw_sem7.service.UserService;
import ru.gb.hw_sem7.service.AdminService;

@Controller
public class HwController {

    private final HwService hwService;
    private final UserService userService;
    private final AdminService adminService;

    public HwController(HwService hwService, UserService userService, AdminService adminService) {
        this.hwService = hwService;
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("text", hwService.getText());
        return "index.html";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("text", userService.getText());
        return "public-data.html";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("text", adminService.getText());
        return "private-data.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
