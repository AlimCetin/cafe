package com.alicetin.cafe.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ICustomerServices<D,E>{

    // INJECTION

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);
    ////////////////////////////////////////////////////////////
    //  C R U D
    // CREATE
    public D customerFoodCreate(D d);


    // FIND
    public List<D> customerFindBycustomerId(Long customerId);

    // DELETE
    public D customerDeleteById(Long id);

    public D customerFindById (Long id);
} //end interface
