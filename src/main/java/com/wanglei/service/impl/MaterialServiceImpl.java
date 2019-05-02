package com.wanglei.service.impl;

import com.wanglei.mapper.MaterialMapper;
import com.wanglei.pojo.Material;
import com.wanglei.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public List<Material> getMaterialList(String[] keywords, Integer page){
        return materialMapper.getMaterialList(keywords, page);
    }

    @Override
    public Integer getCount(String[] keywords) {
        return materialMapper.getCount(keywords);
    }

    @Override
    public boolean insertMaterial(String materialName) {
        if (materialName.isEmpty()) return false;
        materialMapper.insertMaterial(materialName);
        return true;
    }

    @Override
    public void deleteMaterial(Integer materialId) {
        materialMapper.deleteMaterial(materialId);
    }

    @Override
    public boolean updateMaterial(Integer materialId, String newName) {
        if (newName.isEmpty()) return false;
        materialMapper.updateMaterial(materialId, newName);
        return true;
    }
}
