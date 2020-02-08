package com.HRPlus.space;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class HrPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPlusApplication.class, args);
	}

}
