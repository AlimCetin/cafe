package com.alicetin.cafe.data.entity;

import com.alicetin.cafe.data.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@EqualsAndHashCode(callSuper = true)
@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Builder

// ENTITY
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    @Column(name = "customer_id")
    protected  Long customerId;

    @Column(name = "food_list")
    private String foodList;

    @Column(name = "company")
    private String company;

} //end class
