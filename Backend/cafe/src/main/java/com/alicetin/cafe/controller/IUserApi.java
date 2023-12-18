package com.alicetin.cafe.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface IUserApi<D> {

    /////////////////////////////////////////////////////////////
    // LOGIN
    // FIND EMAIL
    public ResponseEntity<?> userFindByEmail(String userEmail);

    ////////////////////////////////////////////////////////////
    // C R U D
    // CREATE
    public ResponseEntity<?> userServiceCreate(D d);

} //end interface

