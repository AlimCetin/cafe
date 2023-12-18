package com.alicetin.cafe.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface ICompanyApi<D> {

    // INJECTION

    // Find By CompanyId
    public ResponseEntity<List<D>> companyFindBycompanyId(Long id);

    // Create
    public ResponseEntity<?> companyFoodCreate(D d);

    // UPDATE
    public ResponseEntity<?> companyFoodUpdate(Long id, D d);

    // DELETE ID
    public ResponseEntity<?> companyFoodDeleteById(Long id);

} //end interface

