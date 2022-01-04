package com.weart.csrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.weart.csrs.Controller"})
@SpringBootApplication
public class CsrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrsApplication.class, args);
	}

}
