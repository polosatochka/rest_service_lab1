package com.urfu.rest_service_lab1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String Uid;
    private String operationUid;
    private String systemTime;
    private String code;
    private String errorCode;
    private String errorMessage;
}
