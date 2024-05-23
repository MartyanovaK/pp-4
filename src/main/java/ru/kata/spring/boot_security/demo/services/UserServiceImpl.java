package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repository.UserDao;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }


    @Override
    public boolean add(User user) {
        userDao.save(user);
        return true;
    }


    @Override
    @Transactional
    public boolean delete(Long id) {
        if(userDao.findById(id).isPresent()) {
            userDao.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public void edit(User userE, Long id) {
        userE.setId(id);
        userDao.save(userE);
    }




    @Override
    public User findByUserName(String email) {
        return userDao.findByEmail(email);
    }


}
