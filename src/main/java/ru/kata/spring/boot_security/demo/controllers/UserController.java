package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.models.User;

import java.security.Principal;

@Controller
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class UserController {
    private final UserDetailsService userService;

    public UserController(UserDetailsService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser(ModelMap model, Principal principal) {
        User user =(User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("helloMessage", "Hello, " + user.getUserName() + " " + user.getLastName() + "!");
        return "user";
    }
}
