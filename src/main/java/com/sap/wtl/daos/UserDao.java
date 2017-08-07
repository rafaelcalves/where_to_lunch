package com.sap.wtl.daos;

import com.sap.wtl.models.User;

public interface UserDao {
    void saveOrUpdate (User user);
    User findByEmail(String email);
}
