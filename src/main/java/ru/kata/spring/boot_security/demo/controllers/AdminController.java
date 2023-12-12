package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;
import java.util.HashSet;
import java.util.Set;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/admin")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        return "/admin";
    }


    @GetMapping("/admin/new")
    public String newUser(ModelMap model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
        return "/new";
    }

    @PostMapping("/admin/new")
    public String add(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("roles", roleService.findAll());
        userService.add(user);
        return "redirect:/admin";

    }

    @GetMapping("/admin/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.findAll());
        return "/edit";
    }


    @PostMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user,@RequestParam("checkRoles") String[] selectResult) {
        Set<Role> roles = new HashSet<>();
        for (String s : selectResult) {
            roles.add(roleService.findRoleByRoleName("ROLE_" + s));
            user.setRoles(roles);
        }
        userService.edit(user);
        return "redirect:/admin";
    }



    @DeleteMapping("/admin/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
