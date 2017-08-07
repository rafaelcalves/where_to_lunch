package com.sap.wtl.services;

import com.sap.wtl.models.User;

public interface UserService {
    void saveOrUpdateUser (User user);
    User findByEmail(String email);
}
