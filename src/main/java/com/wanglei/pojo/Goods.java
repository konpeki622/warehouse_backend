package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    // 基本信息
    private Integer id;
    private Integer material_id;
    private Float material_size;
    private Float inventory_size;
    private Integer area_id;
    private String material_name;
    private String area_name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date material_date;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inventory_date;
    // 记录变更信息
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date update_date;
    private Integer goods_id;
    private String deliver_owner;
    private Float update_size;
    private Integer behavior;
    private String username;
    private Integer place;

    @JsonProperty(value = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value = "material_id")
    public Integer getMaterialId() {
        return material_id;
    }

    public void setMaterialId(Integer material_id) {
        this.material_id = material_id;
    }

    @JsonProperty(value = "material_size")
    public Float getMaterialSize() {
        return material_size;
    }

    public void setMaterialSize(Float material_size) {
        this.material_size = material_size;
    }

    @JsonProperty(value = "inventory_size")
    public Float getInventorySize() {
        return inventory_size;
    }

    public void setInventorySize(Float inventory_size) {
        this.inventory_size = inventory_size;
    }

    @JsonProperty(value = "area_id")
    public Integer getAreaId() {
        return area_id;
    }

    public void setAreaId(Integer area_id) {
        this.area_id = area_id;
    }

    @JsonProperty(value = "material_name")
    public String getMaterialName() {
        return material_name;
    }

    public void setMaterialName(String material_name) {
        this.material_name = material_name;
    }

    @JsonProperty(value = "area_name")
    public String getAreaName() {
        return area_name;
    }

    public void setAreaName(String area_name) {
        this.area_name = area_name;
    }

    @JsonProperty(value = "material_date")
    public Date getMaterialDate() { return material_date; }

    public void setMaterialDate(Date material_date) { this.material_date = material_date; }

    @JsonProperty(value = "inventory_date")
    public Date getInventoryDate() { return inventory_date; }

    public void setInventoryDate(Date inventory_date) { this.inventory_date = inventory_date; }

    @JsonProperty(value = "update_date")
    public Date getUpdateDate() { return update_date; }

    public void setUpdateDate(Date update_date) { this.update_date = update_date; }

    @JsonProperty(value = "goods_id")
    public Integer getGoodsId() {
        return goods_id;
    }

    public void setGoodsId(Integer goods_id) {
        this.goods_id = goods_id;
    }

    @JsonProperty(value = "deliver_owner")
    public String getDeliverOwner() {
        return deliver_owner;
    }

    public void setDeliverOwner(String deliver_owner) {
        this.deliver_owner = deliver_owner;
    }

    @JsonProperty(value = "update_size")
    public Float getUpdateSize() {
        return update_size;
    }

    public void setUpdateSize(Float update_size) {
        this.update_size = update_size;
    }

    @JsonProperty(value = "behavior")
    public Integer getBehavior() {
        return behavior;
    }

    public void setBehavior(Integer behavior) {
        this.behavior = behavior;
    }

    @JsonProperty(value = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty(value = "place")
    public Integer getPlace() {
        return place;
    }
    public void setPlace(Integer place) {
        this.place = place;
    }

}
