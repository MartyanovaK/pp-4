package ru.kata.spring.boot_security.demo.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService  {
    List<User> allUsers();
    void add(User user);
    void delete (Long id);
    void edit(User user);
    User getById(Long id);


}
