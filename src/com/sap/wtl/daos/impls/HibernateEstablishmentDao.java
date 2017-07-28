package com.sap.wtl.daos.impls;

import com.sap.wtl.daos.EstablishmentDao;
import com.sap.wtl.models.Establishment;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HibernateEstablishmentDao extends HibernateDaoSupport implements EstablishmentDao {

    @Transactional
    @Override
    public void saveOrUpdate(Establishment establishment) {
        getHibernateTemplate().saveOrUpdate(establishment);
    }

    @Transactional
    @Override
    public void save(Establishment establishment) {
        getHibernateTemplate().save(establishment);
    }

    @Transactional
    @Override
    public void delete(int id) {
        getHibernateTemplate().delete(getEstablishment(id));
    }

    @Transactional
    @Override
    public void update(Establishment establishment) {
        getHibernateTemplate().update(establishment);
    }

    @Override
    public List<Establishment> listEstablishment() {
        return (List<Establishment>) getHibernateTemplate().find("from com.sap.wtl.models.Establishment");
    }

    @Override
    public Establishment getEstablishment(int id) {
        return getHibernateTemplate().get(Establishment.class,id);
    }

}
