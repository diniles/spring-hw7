package ru.gb.hw7;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    UserService userService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("users", userService.getAll());
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
