package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Organization;

import javax.validation.constraints.NotNull;

public class OrganizationViewList {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @NotNull(message = "name обязательный параметр")
    private String name;

    private Integer inn;

    private Boolean isActive;

    public OrganizationViewList() {}

    public OrganizationViewList(Organization organization) {
        this.id = organization.getoId();
        this.name = organization.getName();
        this.inn = organization.getInn();
        this.isActive = organization.getIsActive();
    }

    @Override
    public String toString() {
        return "{organization_id:" + id + ";organization_name:" + name +
                ";organization_is_active:" + isActive + "}";
    }

    public Integer getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public Integer getInn() {
        return inn;
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

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}