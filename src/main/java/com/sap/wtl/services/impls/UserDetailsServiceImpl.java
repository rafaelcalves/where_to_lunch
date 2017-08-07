package com.sap.wtl.services.impls;


import com.sap.wtl.daos.UserDao;
import com.sap.wtl.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Resource
    private UserDao hibernateUserDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = hibernateUserDao.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
