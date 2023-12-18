package com.alicetin.cafe.controller.impl;

import com.alicetin.cafe.business.dto.CustomerDto;
import com.alicetin.cafe.business.services.ICustomerServices;
import com.alicetin.cafe.controller.ICustomerApi;
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
@RequestMapping("/api/v1.0.0/customers")
@CrossOrigin // CORSS Hatası almamak için
//@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL)
//Dış dünyaya açılan kapı
public class CustomerApiImpl implements ICustomerApi<CustomerDto> {

    // INJECTION
    private final ICustomerServices iCustomerServices;

    //Find by customerId
    @Override
    @GetMapping("/search")
    public ResponseEntity<List<CustomerDto>> customerFindBycustomerId(@RequestParam Long customerId) {
            return ResponseEntity.ok(iCustomerServices.customerFindBycustomerId(customerId));
        }
    // Create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> customerFoodCreate(@Valid @RequestBody CustomerDto customerDto) {
            return ResponseEntity.ok(iCustomerServices.customerFoodCreate(customerDto));
    }
    //Delete Id
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> customerDeleteById(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(iCustomerServices.customerDeleteById(id));
        }


} //end class
