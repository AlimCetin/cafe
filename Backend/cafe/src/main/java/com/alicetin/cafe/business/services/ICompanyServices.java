package com.alicetin.cafe.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ICompanyServices<D,E>{

    // INJECTION

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    /////////////////////////////////////////////////
    // C R U D
    // CREATE
    public D companyFoodCreate(D d);

    // FIND
    public List<D> companyFindBycompanyId(Long companyId);

    // UPDATE
    public D companyFoodUpdate(Long id, D d);

    // DELETE
    public D companyFoodDeleteById(Long id);
    // FİND BY ID
    public D companyFindById(Long id);
} //end interface
