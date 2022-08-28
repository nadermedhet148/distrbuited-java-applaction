package com.javadist.auth.business.service.impl;

import com.javadist.auth.business.service.UserService;
import com.javadist.auth.infrastructure.dao.UserDao;
import com.javadist.auth.infrastructure.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User loadUserByUsername(String username , String password) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        if (!user.getPassword().equals((password))) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return  user;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }


}
