package com.wanglei.mapper;

import com.wanglei.pojo.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {
    List<Area> getAreaList();
}
