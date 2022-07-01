package com.oymn.geoinvestigate.service.impl;

import com.oymn.geoinvestigate.dao.exception.ConditionException;
import com.oymn.geoinvestigate.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    //定义图片的上传路径
    @Value("${IMG_BASE_PATH}")
    private String IMG_BASE_PATH;

    //定义服务器的访问地址
    @Value("${IMG_SERVER_PATH}")
    private String IMG_SERVER_PATH;

    /**
     * 上传文件
     *
     * @param uploadFile
     * @param request
     */
    @Override
    public String uploadFile(MultipartFile uploadFile, HttpServletRequest request) {

        //获得上传文件的名称
        String filename = uploadFile.getOriginalFilename();
        //创建UUID，用来保持文件名字的唯一性
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //进行文件名称的拼接
        String newFileName = uuid + "-" + filename;
        //创建文件实例对象
        File file = new File(IMG_BASE_PATH, newFileName);
        //判断当前文件是否存在
        if (!file.exists()) {
            //如果不存在就创建一个文件夹
            file.mkdirs();
        }
        //执行文件上传的命令
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            throw new ConditionException("图片上传错误，请重新上传");
        }
        //将上传的文件名称返回，注意，这里我们返回一个 服务器地址
        return IMG_SERVER_PATH + newFileName;
    }
}
