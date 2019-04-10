package com.wanglei.service.impl;

import com.wanglei.mapper.AreaMapper;
import com.wanglei.pojo.Area;
import com.wanglei.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAreaList(){
        return areaMapper.getAreaList();
    }
}
