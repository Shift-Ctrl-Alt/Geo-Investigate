package com.oymn.geoinvestigate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Value("${IMG_BASE_PATH}")
    private String IMG_BASE_PATH;
    @Value("${IMG_SERVER_PATH}")
    private String IMG_SERVER_PATH;
    
    @Value("${vueFile}")
    private String htmlFile;
    

    //配置文件上传的服务目录
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //访问http://localhost:8080/img/aaa.jpg  ->   D://aaa.jpg
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + IMG_BASE_PATH);
        registry.addResourceHandler("/html/**").addResourceLocations("file:" + htmlFile);
    }
}
