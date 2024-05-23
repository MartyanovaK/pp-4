package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;


    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }
    @GetMapping()
    public String allUsers(@ModelAttribute("user") User user, Principal principal, Model model) {
        User authUser = userService.findByUserName(principal.getName());
        model.addAttribute("authUser", authUser);
        model.addAttribute("rolesAuthUser", authUser.getRoles());
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("roles", roleService.findAll());
        return "/admin";
    }




    @PostMapping("")
    public String saveUser(@ModelAttribute("user")  User user) {
        userService.add(user);
        return "redirect:/admin";
    }



    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")  User user) {
        userService.edit(user, user.getId());
        return "redirect:/admin";
    }

    @RequestMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
