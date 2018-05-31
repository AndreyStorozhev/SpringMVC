package myspring.dao;

import myspring.entity.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    User getById(int id);
    void delete(int id);
    void update(User user);
    List<User> findAll();
}
