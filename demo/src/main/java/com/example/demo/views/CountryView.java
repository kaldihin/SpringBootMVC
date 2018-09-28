package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Country;

public class CountryView {

    @ApiModelProperty(hidden = true)
    private String name;

    private Integer code;

    public CountryView() {}

    public CountryView(Country country) {
        this.name = country.getCountryName();
        this.code = country.getCountryCode();
    }

    public String getName() {
        return this.name;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{name:" + name + ";code:" + code + "}";
    }
}