package com.sap.wtl.services.impls;

import com.sap.wtl.daos.EstablishmentDao;
import com.sap.wtl.models.Establishment;
import com.sap.wtl.services.EstablishmentService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultEstablishmentService implements EstablishmentService {
    @Resource
    private EstablishmentDao hibernateEstablishmentDao;

    @Override
    public void createEstablishment(Establishment establishment) {
        hibernateEstablishmentDao.save(establishment);
    }

    @Override
    public void updateEstablishment(Establishment establishment) {
        hibernateEstablishmentDao.update(establishment);
    }

    @Override
    public void createUpdateEstablishment(Establishment establishment) {
        hibernateEstablishmentDao.saveOrUpdate(establishment);
    }

    @Override
    public List<Establishment> listEstablishments() {
        return hibernateEstablishmentDao.listEstablishment();
    }

    @Override
    public void deleteEstablishment(int deleteId) {
        hibernateEstablishmentDao.delete(deleteId);
    }

    @Override
    public Establishment getEstablishment(int id) {
        return hibernateEstablishmentDao.getEstablishment(id);
    }
}
