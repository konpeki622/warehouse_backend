package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

@Data
public class Area {
    private Integer area_id;
    private String area_name;

    @JsonProperty(value = "area_id")
    public Integer getAreaId() {
        return area_id;
    }

    public void setAreaId(Integer area_id) {
        this.area_id = area_id;
    }

    @JsonProperty(value = "area_name")
    public String getArea() {
        return area_name;
    }

    public void setAreaId(String area_name) {
        this.area_name = area_name;
    }
}
