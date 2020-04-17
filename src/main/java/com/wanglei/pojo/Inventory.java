package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Inventory {
    private Integer id;
    private Integer goods_id;
    private Integer place;
    private Float occupy;

    @JsonProperty(value = "id")
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value = "place")
    public Integer getPlace() {
        return place;
    }
    public void setPlace(Integer place) {
        this.place = place;
    }

    @JsonProperty(value = "goods_id")
    public Integer getGoodsId() {
        return goods_id;
    }
    public void setGoodsId(Integer goodsId) {
        this.goods_id = goodsId;
    }

    @JsonProperty(value = "occupy")
    public Float getOccupy() {
        return occupy;
    }
    public void setOccupy(Float occupy) {
        this.occupy = occupy;
    }
}
