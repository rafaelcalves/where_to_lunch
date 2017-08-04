package com.sap.wtl.services;

import com.sap.wtl.models.Establishment;
import com.sap.wtl.models.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    void updateUser(User user);

    void createUpdateUser(User user);

    List<User> listUser();

    void deleteUser(int deleteId);

    User getUser(int id);

//    User registerNewUserAccount(User accountDto)
//            throws EmailExistsException;
}
