package com.alicetin.cafe.data.repository;


import com.alicetin.cafe.data.entity.CompanyEntity;
import com.alicetin.cafe.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// 3 2 1 8

// CrudRepository
// JpaRepository
// PagingAndSortingRepository
@Repository
public interface ICompanyRepository extends CrudRepository<CompanyEntity,Long> {
    Iterable<CompanyEntity> findBycompanyId(Long companyId);
} //end interface
