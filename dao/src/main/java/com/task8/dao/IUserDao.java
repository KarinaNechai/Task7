package com.task8.dao;
import com.task8.model.Role;
import com.task8.model.User;
import java.util.List;

public interface IUserDao {
    public boolean insert(User user);
    public boolean update(User user);
    public boolean delete(String login);
    public User getUserBylogin(String login);
    public List <User> getUsersByRole(Role role);
    public User login(String login,String password);
}
