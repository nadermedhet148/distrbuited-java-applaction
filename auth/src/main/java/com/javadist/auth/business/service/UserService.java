package com.javadist.auth.business.service;
import com.javadist.auth.infrastructure.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public User loadUserByUsername(String username , String password) throws UsernameNotFoundException ;
    User save(User user);
}
