package com.startup.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Entity;

@SpringBootApplication
//@EntityScan(value = "com.startup.library")
@EnableJpaRepositories
@EnableSwagger2
public class LibraryApplication {
    public static void main(String[] args){
        SpringApplication.run(LibraryApplication.class,args);
    }
}
