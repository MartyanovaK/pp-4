package ru.kata.spring.boot_security.demo.repository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u",User.class).getResultList();

    }


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class,  id);
        entityManager.remove(user);
    }

    @Override
    public void edit(User userE) {
        entityManager.merge(userE);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class,  id);
    }

    @Override
    public User findByUserName(String userName) {
        Query query = entityManager.createQuery
                ("select u from User u left join fetch u.roles where u.userName=:username", User.class);
        query.setParameter("username", userName);
        return (User) query.getSingleResult();

    }

}