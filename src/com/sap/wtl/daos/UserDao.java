package com.sap.wtl.daos;

import com.sap.wtl.models.User;

import java.util.List;

public interface UserDao {
    void saveOrUpdate(User user);

    void save(User user);

    void delete(int id);

    void update(User user);

    List<User> listUsers();

    User getUser(int id);
}
