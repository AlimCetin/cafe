package com.alicetin.cafe.business.services.impl;


import com.alicetin.cafe.bean.ModelMapperBeanClass;
import com.alicetin.cafe.business.dto.CompanyDto;
import com.alicetin.cafe.business.dto.CustomerDto;
import com.alicetin.cafe.business.services.ICustomerServices;
import com.alicetin.cafe.data.entity.CompanyEntity;
import com.alicetin.cafe.data.entity.CustomerEntity;
import com.alicetin.cafe.data.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICE
// Asıl is Yükünü yapan yer
@Service
public class CustomerImpl implements ICustomerServices<CustomerDto,CustomerEntity> {

    // Injection
    private final ICustomerRepository iCustomerRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;

    @Override
    public CustomerDto entityToDto(CustomerEntity customerEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(customerEntity, CustomerDto.class);
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDto customerDto) {
        return modelMapperBeanClass.modelMapperMethod().map(customerDto, CustomerEntity.class);
    }

    //create
    @Override
    @Transactional
    public CustomerDto customerFoodCreate(CustomerDto customerDto) {
            if (customerDto != null) {
                CustomerEntity createEntity = dtoToEntity(customerDto);
                iCustomerRepository.save(createEntity);
                // Dto Set(id ve date)
                customerDto.setId(createEntity.getId());
                customerDto.setSystemDate(createEntity.getSystemDate());
            }
            return customerDto;
        }
        //Find By Id
        @Override
    public List<CustomerDto> customerFindBycustomerId(Long customerId) {
            Iterable<CustomerEntity> EntityIterable = iCustomerRepository.findBycustomerId(customerId);
            List<CustomerDto> customerDtoList=new ArrayList<>();
            for(CustomerEntity entity: EntityIterable ){
                // Entity Listesini ==> Dto Listesine çeviriyor / list e ekliyor.
                customerDtoList.add(entityToDto(entity));
            }
            return customerDtoList;
    }

    // Delete Find By Id
    @Override
    @Transactional
    public CustomerDto customerDeleteById(Long id) {
            // Öncelikle ilgili Register kaydını bulmalısın.
            CustomerDto registerFindDto= customerFindById(id);
            if(registerFindDto!=null){
                iCustomerRepository.deleteById(id);
            }
            return registerFindDto;
    }

    //Find By Id
    @Override
    public CustomerDto customerFindById(Long id) {
        Optional<CustomerEntity> customerFindEntity=iCustomerRepository.findById(id);
        CustomerDto customerDto=entityToDto(customerFindEntity.get());
        if(customerFindEntity.isPresent()){
            return customerDto;
        }
        return null;
    }

} //end class
