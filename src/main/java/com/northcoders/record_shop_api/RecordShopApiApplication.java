package com.northcoders.record_shop_api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecordShopApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordShopApiApplication.class, args);
    }

    @Bean
    public OpenAPI todoApiInfo() {
        return new OpenAPI()
                .info(new Info().title("Record Shop")
                        .description("Welcome to our record shop!")
                        .version("v1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
