package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repository.UserDao;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }


    @Override
    public void add(User user) {
        userDao.add(user);
    }


    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }


    @Override
    public void edit(User userUp) {
        userDao.edit(userUp);
    }


    @Override
    public User getById(Long id) {
        User userDB = userDao.getById(id);
        if (userDB == null) {
            throw new UsernameNotFoundException(String.format("Пользователь с id = %d не найден", id));
        }
        return userDB;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException(String.format("User %s not found",username));
        }
        return new  org.springframework.security.core.userdetails.User( user.getUsername(),user.getPassword(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isEnabled(), user.isAccountNonLocked(),
                user.getRoles());
    }

}
