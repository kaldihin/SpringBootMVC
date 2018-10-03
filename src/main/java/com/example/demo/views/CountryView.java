package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Country;

import javax.validation.constraints.NotNull;

public class CountryView {

    @ApiModelProperty(hidden = true)

    @NotNull(message = "name обязательный параметр")
    private String name;

    @NotNull(message = "version обязательный параметр")
    private Integer version;

    private Integer code;

    public CountryView() {}

    public CountryView(Country country) {
        this.name = country.getCountryName();
        this.version = country.getVersion();
        this.code = country.getCountryCode();
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public Integer getVersion() {
        return version;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setVersion(@NotNull Integer version) {
        this.version = version;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{name:" + name + ";code:" + code + "}";
    }
}