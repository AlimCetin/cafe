package com.alicetin.cafe.business.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@Log4j2
@Builder
@AllArgsConstructor
@NoArgsConstructor
// REGISTER
public class UserDto extends BaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userType;



} //end class
