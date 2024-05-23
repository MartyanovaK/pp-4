package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService  {
    List<User> allUsers();
    boolean add(User user);
    boolean delete (Long id);
    void edit(User user, Long id);

    User findByUserName(String userName);


}
