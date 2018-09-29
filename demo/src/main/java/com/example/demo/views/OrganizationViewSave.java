package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Organization;

import javax.validation.constraints.NotNull;

public class OrganizationViewSave {

    @ApiModelProperty(hidden = true)

    private Integer id;

    @NotNull(message = "name обязательный параметр")
    private String name;

    @NotNull(message = "fullName обязательный параметр")
    private String fullName;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @NotNull(message = "version обязательный параметр")
    private Integer version;

    @NotNull(message = "inn обязательный параметр")
    private Integer inn;

    @NotNull(message = "kpp обязательный параметр")
    private Integer kpp;

    @NotNull(message = "address обязательный параметр")
    private String address;

    private String phone;

    private Boolean isActive;

    public OrganizationViewSave() {}

    public OrganizationViewSave(Organization organization) {
        this.name = organization.getName();
        this.fullName = organization.getFullName();
        this.inn = organization.getInn();
        this.kpp = organization.getKpp();
        this.address = organization.getAddress();
        this.phone = organization.getPhone();
        this.isActive = organization.getIsActive();
    }

    @Override
    public String toString() {
        return ";organization_name:" + name + ";organization_fullname:" + fullName +
                ";organization_inn:" + inn + ";organization_kpp:" + kpp + ";organization_address:" + address +
                ";organization_phone:" + phone + ";organization_is_active:" + isActive + "}";
    }

    public Integer getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getFullName() {
        return fullName;
    }

    @NotNull
    public Integer getInn() {
        return inn;
    }

    @NotNull
    public Integer getKpp() {
        return kpp;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setFullName(@NotNull String fullName) {
        this.fullName = fullName;
    }

    public void setInn(@NotNull Integer inn) {
        this.inn = inn;
    }

    public void setKpp(@NotNull Integer kpp) {
        this.kpp = kpp;
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
}