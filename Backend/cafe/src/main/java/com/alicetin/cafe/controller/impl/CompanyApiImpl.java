package com.alicetin.cafe.controller.impl;

import com.alicetin.cafe.business.dto.CompanyDto;
import com.alicetin.cafe.business.services.ICompanyServices;
import com.alicetin.cafe.controller.ICompanyApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //ınjection
@Log4j2

// API
@RestController
//v1.0.0       1: major version 0: minor 0: patch(yama)
@RequestMapping("/api/v1.0.0/companys")
@CrossOrigin // CORSS Hatası almamak için
//Dış dünyaya açılan kapı
public class CompanyApiImpl implements ICompanyApi<CompanyDto> {

    // INJECTION
    private final ICompanyServices iCompanyServices;
    // Find By companyId
    @Override
    @GetMapping("/search")
    public ResponseEntity<List<CompanyDto>> companyFindBycompanyId(@RequestParam Long id) {
               return ResponseEntity.ok(iCompanyServices.companyFindBycompanyId(id));
        }
    //Create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> companyFoodCreate(@Valid @RequestBody CompanyDto companyDto) {
            return ResponseEntity.ok(iCompanyServices.companyFoodCreate(companyDto)) ;
        }
    //Update
    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> companyFoodUpdate(@PathVariable(name="id") Long id,@Valid @RequestBody CompanyDto companyDto) {
            return ResponseEntity.status(HttpStatus.OK).body(iCompanyServices.companyFoodUpdate(id,companyDto));
        }
    //Delete id
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> companyFoodDeleteById(@PathVariable(name="id") Long id) {
            return ResponseEntity.ok(iCompanyServices.companyFoodDeleteById(id));
        }

} //end class
