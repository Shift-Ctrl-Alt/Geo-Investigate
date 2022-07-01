package com.oymn.geoinvestigate.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {

    String uploadFile(MultipartFile uploadFile, HttpServletRequest request);
    
}
