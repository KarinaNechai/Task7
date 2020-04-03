package com.task8.dao.impl;

import com.task8.dao.IUserDao;
import com.task8.model.Role;
import com.task8.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDao implements IUserDao {
    private static volatile UserDao instance;
    private Map<String,User> users;

    private UserDao() {
        this.users = new HashMap<>();
        users.put("admin",new User("Ivanov","Ivan","375298888888","my@tut.by","admin","admin",Role.ADMIN));
        users.put("Petrov",new User("Petrov","Petr","375298888881","my1@tut.by","Petrov","Petrov",Role.USERS));
        users.put("Semenov",new User("Semenov","Semen","375298228881","my2@tut.by","Semenov","Semenov",Role.USERS));
    }


    public static UserDao getInstance() {
        UserDao localInstance = instance;
        if (localInstance == null) {
            synchronized (UserDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new UserDao();
                }
            }
        }
        return localInstance;
    }

    @Override
    public boolean insert(User user) {
        if (user==null) return false;
        if (users.containsKey(user.getLogin())) return false;
        users.putIfAbsent(user.getLogin(),user);
        return users.containsKey(user.getLogin());
    }

    @Override
    public boolean update(User user) {
        if (user==null) return false;
        if (users.get(user.getLogin())==null) return false;
        users.replace(user.getLogin(),user);
        return true;
    }

    @Override
    public boolean delete(String login) {
        User resultUser=users.get(login);
        if ((resultUser==null)||(!resultUser.isActual())) {
            return false;
        }
        else{
            resultUser.setActual(false);
            return update(resultUser);
        }
    }

    @Override
    public User getUserBylogin(String login) {
        if (login==null) return null;
         return users.get(login);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return users.values().stream().filter(User::isActual).filter(user -> user.getRole().
                toString().equals(role.toString())).collect(Collectors.toList());
    }

    @Override
    public User login(String login, String password) {
        User a=getUserBylogin(login);
        if (a==null) return null;
        boolean b=a.getPassword().equals(password);
        return a.getPassword().equals(password)?a:null;
    }

}
