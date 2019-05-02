package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GoodsSum {

    private Float goods_sum;
    private String key_name;

    @JsonProperty(value = "goods_sum")
    public Float getGoodsSum() {
        return goods_sum;
    }
    public void setGoodsSum(Float goods_sum) {
        this.goods_sum = goods_sum;
    }

    @JsonProperty(value = "key_name")
    public String getKeyName() {
        return key_name;
    }
    public void setKeyName(String key_name) {
        this.key_name = key_name;
    }
}
