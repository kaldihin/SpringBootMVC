package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Doc;

import javax.validation.constraints.NotNull;

public class DocView {

    @ApiModelProperty(hidden = true)

    @NotNull(message = "name обязательный параметр")
    private String name;

    @NotNull(message = "version обязательный параметр")
    private Integer version;

    private Integer code;

    public DocView() {}

    public DocView(Doc doc) {
        this.name = doc.getName();
        this.version = doc.getVersion();
        this.code = doc.getCode();
    }

    @NotNull
    public String getName() {
        return name;
    }
    @NotNull
    public Integer getVersion() {
        return version;
    }

    public Integer getCode() {
        return code;
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
        return "{doc_name:" + name + ";doc_code:" + code + "}";
    }
}