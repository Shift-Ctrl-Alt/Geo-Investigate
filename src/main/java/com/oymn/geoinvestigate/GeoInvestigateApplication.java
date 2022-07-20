package com.oymn.geoinvestigate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi //Enable open api 3.0.3 spec
public class GeoInvestigateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoInvestigateApplication.class, args);
    }

}
