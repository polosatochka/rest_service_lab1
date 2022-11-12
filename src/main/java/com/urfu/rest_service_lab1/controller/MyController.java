package com.urfu.rest_service_lab1.controller;

import com.urfu.rest_service_lab1.model.Request;
import com.urfu.rest_service_lab1.model.Response;
import com.urfu.rest_service_lab1.service.ModifyRequestService;
import com.urfu.rest_service_lab1.service.MyModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(@Qualifier("ModifySystemTime") MyModifyService myModifyService, ModifyRequestService modifyRequestService){
        this.myModifyService = myModifyService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){
        log.info("Входящий request : " + String.valueOf(request));

        Response response = Response.builder()
                .Uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("successful connection")
                .errorCode("")
                .errorMessage("")
                .build();

        modifyRequestService.modifyRq(request);

        Response responseAfterModification = myModifyService.modify(response);

        log.info("Исходящий response : " + String.valueOf(response));

        return new ResponseEntity<>(responseAfterModification, HttpStatus.OK);
    }
}
