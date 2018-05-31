package myspring.dao;

import myspring.entity.User;
import myspring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO persn (name, email, age) VALUES (?, ?, ?)",
                user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
       return jdbcTemplate.queryForObject("SELECT * FROM persn WHERE id = ?", new UserMapper(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM persn WHERE id = ?", id);
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE persn SET name = ?, email = ?, age = ? WHERE id = ?",
                user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM persn", new UserMapper());
    }
}
