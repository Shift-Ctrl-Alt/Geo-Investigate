package com.oymn.geoinvestigate.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {

    void uploadFile(MultipartFile uploadImg, HttpServletRequest request);
    
}
