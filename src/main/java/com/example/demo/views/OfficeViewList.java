package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Office;

import javax.validation.constraints.NotNull;

public class OfficeViewList {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @NotNull(message = "orgId обязательный параметр")
    private Integer orgId;

    private String name;

    private String address;

    private String phone;

    private Boolean isActive;

    public OfficeViewList() {}

    public OfficeViewList(Office office) {
        this.id = office.getOfId();
        this.orgId = office.getOrgId();
        this.name = office.getName();
        this.address = office.getAddress();
        this.phone = office.getPhone();
        this.isActive = office.getIsActive();
    }

    @Override
    public String toString() {
        return "{office_id:" + id + ";office_name:" + name +
                ";office_is_active:" + isActive + "}";
    }

    public Integer getId() {
        return id;
    }

    @NotNull
    public Integer getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrgId(@NotNull Integer orgId) {
        this.orgId = orgId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}