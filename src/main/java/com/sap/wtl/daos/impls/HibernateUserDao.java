package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.UserDao;
import com.sap.wtl.models.User;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class HibernateUserDao extends HibernateDaoSupport implements UserDao {
    @Override
    public void saveOrUpdate(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public User findByEmail(String email) {
        String query = "from com.sap.wtl.models.User where email like :pEmail";
        List<User> retQuery = (List<User>) getHibernateTemplate().findByNamedParam(query,"pEmail",email);
        User retUser = null;

        if (retQuery.size() > 0){
            retUser = retQuery.get(0);
        }
        return retUser;
    }
}
