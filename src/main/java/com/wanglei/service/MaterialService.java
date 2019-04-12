package com.wanglei.service;

import com.wanglei.pojo.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getMaterialList(Integer type, String[] keywords);
    boolean insertMaterial(String materialName);
    void deleteMaterial(Integer materialId);
    boolean updateMaterial(Integer materialId, String newName);
}
