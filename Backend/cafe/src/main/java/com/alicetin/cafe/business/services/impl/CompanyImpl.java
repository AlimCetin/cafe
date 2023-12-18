package com.alicetin.cafe.business.services.impl;


import com.alicetin.cafe.bean.ModelMapperBeanClass;
import com.alicetin.cafe.business.dto.CompanyDto;
import com.alicetin.cafe.business.dto.CustomerDto;
import com.alicetin.cafe.business.services.ICompanyServices;
import com.alicetin.cafe.data.entity.CompanyEntity;
import com.alicetin.cafe.data.repository.ICompanyRepository;
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
public class CompanyImpl implements ICompanyServices<CompanyDto, CompanyEntity> {

    // Injection
    private final ICompanyRepository iCompanyRepository;
    private final ModelMapperBeanClass modelMapperBeanClass;

    @Override
    public CompanyDto entityToDto(CompanyEntity companyEntity) {
        return modelMapperBeanClass.modelMapperMethod().map(companyEntity, CompanyDto.class);
    }

    @Override
    public CompanyEntity dtoToEntity(CompanyDto companyDto) {
        return modelMapperBeanClass.modelMapperMethod().map(companyDto, CompanyEntity.class);
    }
    //create
    @Override
    @Transactional
    public CompanyDto companyFoodCreate(CompanyDto companyDto) {

            if (companyDto != null) {
                CompanyEntity createEntity = dtoToEntity(companyDto);
                iCompanyRepository.save(createEntity);
                // Dto Set(id ve date)
                companyDto.setId(createEntity.getId());
                companyDto.setSystemDate(createEntity.getSystemDate());
            }
            return companyDto;
        }


    @Override
    public List<CompanyDto> companyFindBycompanyId(Long companyId) {
        Iterable<CompanyEntity> EntityIterable = iCompanyRepository.findBycompanyId(companyId);
        List<CompanyDto> companyDtoList=new ArrayList<>();
        for(CompanyEntity entity: EntityIterable ){
            // Entity Listesini ==> Dto Listesine çeviriyor / list e ekliyor.
            companyDtoList.add(entityToDto(entity));
        }
        return companyDtoList;
    }

    @Override
    public CompanyDto companyFoodUpdate(Long id, CompanyDto companyDto) {
        return null;
    }

    @Override
    @Transactional
    public CompanyDto companyFoodDeleteById(Long id) {
        // Öncelikle ilgili Register kaydını bulmalısın.
      CompanyDto registerFindDto= companyFindById(id);
        if(registerFindDto!=null){
            iCompanyRepository.deleteById(id);
        }
        return registerFindDto;
        }

    @Override
    public CompanyDto companyFindById(Long id) {
        Optional<CompanyEntity> CompanyFindEntity=iCompanyRepository.findById(id);
        CompanyDto companyDto=entityToDto(CompanyFindEntity.get());
        if(CompanyFindEntity.isPresent()){
            return companyDto;
        }
        return null;
    }
} //end class
