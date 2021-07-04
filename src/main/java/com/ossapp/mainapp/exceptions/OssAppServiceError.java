package com.ossapp.mainapp.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class OssAppServiceError {
    private int status;
    private String message;
    private Date timestamp;

    public OssAppServiceError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
