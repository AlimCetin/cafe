package com.alicetin.cafe.controller.impl;

import com.alicetin.cafe.business.dto.UserDto;
import com.alicetin.cafe.business.services.IUserServices;
import com.alicetin.cafe.controller.IUserApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// LOMBOK
@RequiredArgsConstructor //ınjection
@Log4j2

// API
@RestController
//v1.0.0       1: major version 0: minor 0: patch(yama)
@RequestMapping("/api/v1.0.0/users")
@CrossOrigin // CORSS Hatası almamak için
//@CrossOrigin(origins = FrontendPortUrl.REACT_FRONTEND_PORT_URL)
//Dış dünyaya açılan kapı
public class UserApiImpl implements IUserApi<UserDto> {

    // INJECTION

    private final IUserServices iUserServices;

    @Override
    @GetMapping("/search")
    public ResponseEntity<?> userFindByEmail(@RequestParam String userEmail) {
        System.out.println("++++++++++++++++"+userEmail);
            return ResponseEntity.ok(iUserServices.userFindByEmail(userEmail));
        }

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> userServiceCreate(@Valid @RequestBody UserDto userDto) {
            return ResponseEntity.ok(iUserServices.userServiceCreate(userDto)) ;
        }


} //end class
