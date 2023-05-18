package com.example.simple_banking_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.example.simple_banking_app.exchange_rate_provider",})
public class SimpleBankingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBankingAppApplication.class, args);
    }

}
