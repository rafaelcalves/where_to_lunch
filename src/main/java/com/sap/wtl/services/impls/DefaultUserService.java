package com.sap.wtl.services.impls;

import com.sap.wtl.daos.UserDao;
import com.sap.wtl.models.User;
import com.sap.wtl.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Transactional
public class DefaultUserService implements UserService {
    @Resource
    private UserDao hibernateUserDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveOrUpdateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        hibernateUserDao.saveOrUpdate(user);
    }

    @Override
    public User findByEmail(String email) {
        return hibernateUserDao.findByEmail(email);
    }

    @Override
    public User findById(int userId) {
        return hibernateUserDao.findById(userId);
    }
}
