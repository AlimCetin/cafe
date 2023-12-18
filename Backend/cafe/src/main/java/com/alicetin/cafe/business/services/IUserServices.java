package com.alicetin.cafe.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IUserServices<D,E>{

    // INJECTION

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    ////////////////////////////////////////////////////////////
    // LOGIN
    // FIND E mail
    public D userFindByEmail(String userEmail);

    ////////////////////////////////////////////////////////////
    //  REGISTER C R U D
    // CREATE
    public D userServiceCreate(D d);

} //end interface
