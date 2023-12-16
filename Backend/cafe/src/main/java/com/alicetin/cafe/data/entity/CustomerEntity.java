package com.alicetin.cafe.data.entity;

import com.alicetin.cafe.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Builder

// ENTITY
@Entity
@Table(name = "User")
public class CustomerEntity extends BaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // Global Variable (6)
    // Dikkat: message sonunda boşluk olmasın
    // unique = true,
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String registerEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_type")
    private Boolean registerIsPassive=false;
} //end class
