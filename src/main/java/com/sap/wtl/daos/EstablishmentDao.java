package com.sap.wtl.daos;

import com.sap.wtl.models.Establishment;

import java.util.List;

public interface EstablishmentDao {
    void saveOrUpdate(Establishment establishment);

    void save(Establishment establishment);

    void delete(int id);

    void update(Establishment establishment);

    List<Establishment> listEstablishment();

    Establishment getEstablishment(int id);
}
