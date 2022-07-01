package com.oymn.geoinvestigate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    //配置 Swagger的Docket的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true) //设置是否启动Swagger
                .select()
                //RequestHandlerSelectors，配置要扫描的接口方法
                //basePackage：指定要扫描的包
                //any()：扫描全部
                //none()：都不扫描
                //withClassAnnotation()：扫描类上的注解——参数是一个注解的反射对象
                //withMethodAnnotation()：扫描方法上的注解——get post
                .apis(RequestHandlerSelectors.basePackage("com.oymn.geoinvestigate.controller"))
                .paths(PathSelectors.ant("/**"))//过滤地址
                .build();//工厂模式
    }
    
    //配置Swagger信息   apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("地调APP", null, null);
        return new ApiInfo("地调APP的API文档",
                "地调APP",
                "1.0",
                null,
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
    
    
}


