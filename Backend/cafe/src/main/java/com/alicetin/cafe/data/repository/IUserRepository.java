package com.alicetin.cafe.data.repository;


import com.alicetin.cafe.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// 3 2 1 8

// CrudRepository
// JpaRepository
// PagingAndSortingRepository
@Repository
public interface IUserRepository extends CrudRepository<UserEntity,Long> {
    Iterable<UserEntity> findByuserEmail(String userEmail);

} //end interface
