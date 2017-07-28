package com.sap.wtl.services;

import com.sap.wtl.models.Establishment;

import java.util.List;

public interface EstablishmentService {
    void createEstablishment(Establishment establishment);

    void updateEstablishment(Establishment establishment);

    void createUpdateEstablishment(Establishment establishment);

    List<Establishment> listEstablishments();

    void deleteEstablishment(int deleteId);

    Establishment getEstablishment(int id);
}
