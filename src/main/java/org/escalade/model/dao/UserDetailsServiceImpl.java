package org.escalade.model.dao;

import org.escalade.model.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    PasswordEncoder passwordEncoder;
    UserDao userDao;


    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("User : {}", user.getUsername());

        if (user == null) {
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().getName());
        authorities.add(authority);
        logger.info("authorities : {}", authorities);
        return authorities;
    }
}
