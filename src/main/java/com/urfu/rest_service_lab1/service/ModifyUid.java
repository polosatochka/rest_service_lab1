package com.urfu.rest_service_lab1.service;

import com.urfu.rest_service_lab1.model.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ModifyUid")
public class ModifyUid implements MyModifyService{
    @Override
    public Response modify(Response response){
        response.setUid("NewUid");
        return response;
    }
}
