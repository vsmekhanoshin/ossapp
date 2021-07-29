package com.ossapp.mainapp.service.impl;

import com.ossapp.mainapp.service.ImageSaveService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageSaveServiceImpl implements ImageSaveService {
    private static final String UPLOADED_FOLDER = "./images/";

    public String saveFile(MultipartFile file, String userName){
        if (file.isEmpty()){
            return "";
        }
        String userFolderName = UPLOADED_FOLDER + userName + "/";
        String filename = UUID.randomUUID() + file.getOriginalFilename();
        try {
            Path path = Paths.get(userFolderName + filename);
            file.transferTo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
