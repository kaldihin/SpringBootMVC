package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Office;

import javax.validation.constraints.NotNull;

public class OfficeViewUpdate {

    @ApiModelProperty(hidden = true)
    @NotNull(message = "id обязательный параметр")
    private Integer id;

    private Integer orgId;

    @NotNull(message = "version обязательный параметр")
    private Integer version;

    @NotNull(message = "name обязательный параметр")
    private String name;

    @NotNull(message = "address обязательный параметр")
    private String address;

    private String phone;

    private Boolean isActive;

    public OfficeViewUpdate() {}

    public OfficeViewUpdate(Office office) {
        this.id = office.getOfId();
        this.orgId = office.getOrgId();
        this.version = office.getVersion();
        this.name = office.getName();
        this.address = office.getAddress();
        this.phone = office.getPhone();
        this.isActive = office.getIsActive();
    }

    @NotNull
    public Integer getId() {
        return id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    @NotNull
    public Integer getVersion() {
        return version;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setId(@NotNull Integer id) {
        this.id = id;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public void setVersion(@NotNull Integer version) {
        this.version = version;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{office_id:" + id + ";office_name:" + name + ";office_address:"
                + address + ";office_phone:" + phone + ";office_is_active:" +
                isActive + "}";
    }
}