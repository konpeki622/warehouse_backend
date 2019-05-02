package com.wanglei.mapper;

import com.wanglei.pojo.Material;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {
    List<Material> getMaterialList(@Param("keywords")String[] keywords, @Param("page") Integer page);
    Integer getCount(@Param("keywords")String[] keywords);
    void insertMaterial(String materialName);
    void deleteMaterial(Integer materialId);
    void updateMaterial(@Param("material_id")Integer materialId, @Param("material_name")String materialName);
}
