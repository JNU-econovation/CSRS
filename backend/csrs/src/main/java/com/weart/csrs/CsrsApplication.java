package com.weart.csrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.weart.csrs.domain")
@EnableJpaRepositories("com.weart.csrs.Repository")
@SpringBootApplication
public class CsrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsrsApplication.class, args);
    }

}
