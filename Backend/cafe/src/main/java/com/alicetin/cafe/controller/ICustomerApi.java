package com.alicetin.cafe.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface ICustomerApi<D> {



    /////////////////////////////////////////////////////////////
    // LOGIN
    // FIND BY EMAIL
    public ResponseEntity<List<D>> customerFindBycustomerId(Long customerId);

    ////////////////////////////////////////////////////////////

    // C R U D
    // CREATE
    public ResponseEntity<?> customerFoodCreate(D d);

    // DELETE
    public ResponseEntity<?> customerDeleteById(Long id);

} //end interface

