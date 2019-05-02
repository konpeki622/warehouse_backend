package com.wanglei.controller;

import com.wanglei.pojo.Area;
import com.wanglei.pojo.ResponseMessage;
import com.wanglei.service.AreaService;
import com.wanglei.util.CheckToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AreaController {
    @Autowired
    private AreaService areaService;

    @CheckToken
    @RequestMapping(value = {"/area"}, method = RequestMethod.GET)
    public ResponseMessage areaController(){
        List<Area> areas = areaService.getAreaList();
        return new ResponseMessage<>(areas, areas.size()).success();
    }
}
