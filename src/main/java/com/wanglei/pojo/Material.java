package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
 * 原料实体
 * 与原料表对应
 *
 */
@Data
public class Material {
    private Integer material_id;
    private String material_name;

    @JsonProperty(value = "material_id")
    public Integer getMaterialId() {
        return this.material_id;
    }

    public void setMaterialId(Integer id) {
        this.material_id = id;
    }

    @JsonProperty(value = "material_name")
    public String getMaterialName() {
        return material_name;
    }

    public void setMaterialName(String material_name) {
        this.material_name = material_name;
    }
}