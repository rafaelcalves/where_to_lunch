package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.UserDao;
import com.sap.wtl.models.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class HibernateUserDao extends HibernateDaoSupport implements UserDao {
    @Override
    public void saveOrUpdate(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void delete(int id) {
        getHibernateTemplate().delete(getUser(id));
    }

    @Override
    public void update(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public List<User> listUsers() {
        return (List<User>) getHibernateTemplate().find("from com.sap.wtl.models.User");
    }

    @Override
    public User getUser(int id) {
        return getHibernateTemplate().get(User.class,id);
    }
}
