package com.alicetin.cafe.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@Log4j2 // for log

// @Configuration: Classın Bean nesnesi olması için kullanıyoruz.
@Configuration
public class AllBean {

    // Model Mapper
    @Bean(initMethod = "modelMapperBeforeBeanMethod",destroyMethod ="modelMapperAfterBeanMethod")
    public ModelMapperBeanClass modelMapperBeanClass(){
        return new ModelMapperBeanClass();
    }



    // Swagger
    @Bean(initMethod = "swaggerOpenApiBeforeBeanMethod",destroyMethod ="swaggerOpenApiAfterBeanMethod")
    public SwaggerOpenApiBeanClass swaggerOpenApiBeanClass(){
        return new SwaggerOpenApiBeanClass();
    }

} //end class
