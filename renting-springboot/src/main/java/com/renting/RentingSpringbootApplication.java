package com.renting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(basePackages = "com.renting.dao")
@SpringBootApplication
public class RentingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentingSpringbootApplication.class, args);
	}

}
