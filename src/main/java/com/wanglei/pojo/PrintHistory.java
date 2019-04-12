package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PrintHistory {
    private Integer id;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private String print_date;
    private String username;
    private Integer behavior;
    private Integer goods_id;

    @JsonProperty(value = "id")
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value = "print_date")
    public String getPrintDate() {
        return print_date;
    }
    public void setPrintDate(String print_date) {
        this.print_date = print_date;
    }

    @JsonProperty(value = "username")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @JsonProperty(value = "behavior")
    public Integer getBehavior() {return behavior; }
    public void setBehavior(Integer behavior) { this.behavior = behavior; }

    @JsonProperty(value = "goods_id")
    public Integer getGoodsId() { return goods_id;}
    public void setGoodsId(Integer goods_id) { this.goods_id = goods_id; }
}
