package com.wanglei.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShelveInfo {
    private Integer id;
    private Integer rowNo;
    private Integer col;
    private Integer floor;
    private Integer capacity;
    private Integer occupy;
    private Integer place;
    private String space_name;
    private String material_name;
    private String area_name;

    @JsonProperty(value = "id")
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value = "row")
    public Integer getRowNo() {
        return rowNo;
    }
    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    @JsonProperty(value = "col")
    public Integer getCol() { return col; }
    public void setCol(Integer col) { this.col = col; }

    @JsonProperty(value = "floor")
    public Integer getFloor() { return this.floor; }
    public void setFloor(Integer floor) { this.floor = floor; }

    @JsonProperty(value = "capacity")
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    @JsonProperty(value = "occupy")
    public Integer getOccupy() {
        return occupy;
    }
    public void setOccupy(Integer occupy) {
        this.occupy = occupy;
    }

    @JsonProperty(value = "place")
    public Integer getPlace() { return this.place; }
    public void setPlace(Integer place) { this.place = place; }

    @JsonProperty(value = "space_name")
    public String getSpaceName() {
        return space_name;
    }
    public void setSpaceName(String space_name) {
        this.space_name = space_name;
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
}
