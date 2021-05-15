package com.ossapp.mainapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageSaveService {
    public String saveFile(MultipartFile file, String userName);
}
