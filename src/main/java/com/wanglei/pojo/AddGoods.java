package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
public class AddGoods {
    // 基本信息
    private Integer id;
    private Integer material_id;
    private Integer area_id;
    // 记录变更信息
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private String update_date;
    private Integer goods_id;
    private String deliver_owner;
    private Integer update_size;
    private Integer behavior;
    private String username;

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

    @JsonProperty(value = "area_id")
    public Integer getAreaId() {
        return area_id;
    }

    public void setAreaId(Integer area_id) {
        this.area_id = area_id;
    }

    @JsonProperty(value = "update_date")
    public String getUpdateDate() {
        return update_date;
    }

    public void setUpdateDate(String update_date) { this.update_date = update_date; }

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
    public Integer getUpdateSize() {
        return update_size;
    }

    public void setUpdateSize(Integer update_size) {
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
}
