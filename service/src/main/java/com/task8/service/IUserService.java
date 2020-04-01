package com.task8.service;
import com.task8.model.Role;
import com.task8.model.User;

import java.util.List;

public interface IUserService {
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(String login);
    public User getUser(String login);
    public User login (String login,String password);
    public List <User> getUsersOfSystem();
}
