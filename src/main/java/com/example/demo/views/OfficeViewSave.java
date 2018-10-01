package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Office;

import javax.validation.constraints.NotNull;

public class OfficeViewSave {

    @ApiModelProperty(hidden = true)
    private Integer id;

    private Integer orgId;

    @NotNull
    public Integer getVersion() {
        return version;
    }

    public void setVersion(@NotNull Integer version) {
        this.version = version;
    }

    @NotNull(message = "version обязательный параметр")
    private Integer version;

    private String name;

    private String address;

    private String phone;

    private Boolean isActive;

    public OfficeViewSave() {}

    public OfficeViewSave(Office office) {
        this.id = office.getOfId();
        this.orgId = office.getOrgId();
        this.version = office.getVersion();
        this.name = office.getName();
        this.address = office.getAddress();
        this.phone = office.getPhone();
        this.isActive = office.getIsActive();
    }

    @Override
    public String toString() {
        return "{office_id:" + id + ";office_name:" + name + ";office_address:"
                + address + ";office_phone:" + phone + ";office_is_active:" +
                isActive + "}";
    }

    public Integer getId() {
        return id;
    }

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

    public void setOrgId(Integer orgId) {
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