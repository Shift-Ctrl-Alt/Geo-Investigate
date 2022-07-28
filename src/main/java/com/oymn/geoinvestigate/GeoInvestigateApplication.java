package com.oymn.geoinvestigate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi //Enable open api 3.0.3 spec
public class GeoInvestigateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoInvestigateApplication.class, args);
    }

/*    @RequestMapping(value = "/html/", method = RequestMethod.GET)
    public String index() {
        return "redirect:web/index.html";
    }*/

}
