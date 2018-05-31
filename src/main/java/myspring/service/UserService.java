package myspring.service;

import myspring.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void saveUser(User user);
    User getById(int id);
    void delete(int id);
    void update(User user);
}
