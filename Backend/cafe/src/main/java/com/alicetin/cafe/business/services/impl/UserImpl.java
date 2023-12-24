package com.alicetin.cafe.business.services.impl;


import com.alicetin.cafe.bean.ModelMapperBeanClass;
import com.alicetin.cafe.business.dto.UserDto;
import com.alicetin.cafe.business.services.IUserServices;
import com.alicetin.cafe.data.entity.UserEntity;
import com.alicetin.cafe.data.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICE
// Asıl is Yükünü yapan yer
@Service
public class UserImpl implements IUserServices<UserDto, UserEntity> {

    // Injection
    @Autowired
    private final IUserRepository iUserRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;


    @Override
    public UserDto entityToDto(UserEntity userEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity dtoToEntity(UserDto userDto) {
        return modelMapperBeanClass.modelMapperMethod().map(userDto, UserEntity.class);
    }
    //Find By userEmail
    @Override
    public List<UserDto> userFindByEmail(String userEmail) {
            Iterable<UserEntity> registerEntityIterable = iUserRepository.findByuserEmail(userEmail);            List<UserDto> registerDtoList=new ArrayList<>();
            for(UserEntity entity: registerEntityIterable ){
                // Entity Listesini ==> Dto Listesine çeviriyor / list e ekliyor.
                registerDtoList.add(entityToDto(entity));
            }
            return registerDtoList;
        }

    // create
    @Override
    @Transactional
    public UserDto userServiceCreate(UserDto userDto) {
            if (userDto != null) {
                UserEntity registerEntity = dtoToEntity(userDto);
                // Password Encoder Bean
                iUserRepository.save(registerEntity);
                // Dto Set(id ve date)
                userDto.setId(registerEntity.getId());
                userDto.setSystemDate(registerEntity.getSystemDate());
            }
            return userDto;
        }
} //end class
