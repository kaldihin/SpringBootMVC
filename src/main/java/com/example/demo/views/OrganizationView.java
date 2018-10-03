package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Organization;

public class OrganizationView {

    @ApiModelProperty(hidden = true)
    private Integer id;

    private String name;

    private String fullName;

    private Integer version;

    private Integer inn;

    private Integer kpp;

    private String address;

    private String phone;

    private Boolean isActive;

    public OrganizationView() {}

    public OrganizationView(Organization organization) {
        this.id = organization.getoId();
        this.name = organization.getName();
        this.fullName = organization.getFullName();
        this.version = organization.getVersion();
        this.inn = organization.getInn();
        this.kpp = organization.getKpp();
        this.address = organization.getAddress();
        this.phone = organization.getPhone();
        this.isActive = organization.getIsActive();
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getInn() {
        return inn;
    }

    public Integer getKpp() {
        return kpp;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
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

    @Override
    public String toString() {
        return "{organization_id:" + id + ";organization_name:" + name + ";organization_fullname:" + fullName +
                ";organization_inn:" + inn + ";organization_kpp:" + kpp + ";organization_address:" + address +
                ";organization_phone:" + phone + ";organization_is_active:" + isActive + "}";
    }
}