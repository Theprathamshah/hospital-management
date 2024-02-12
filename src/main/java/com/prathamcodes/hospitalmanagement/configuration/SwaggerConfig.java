package com.prathamcodes.hospitalmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
   private ApiInfo apiInfo(){
       return new ApiInfo("Hospital Management REST APIs","APIs for HOSPITAL","1.0","Terms of service",
               new Contact("test","www.org.com","test@gmail.com"),
               "License of API","Api license URL",
               Collections.emptyList());
   }
   @Bean
    public Docket api(){
       return new Docket(DocumentationType.OAS_30)
               .apiInfo(apiInfo())
               .select()
               .apis(RequestHandlerSelectors.any())
               .paths(PathSelectors.any())
               .build();
   }
}
