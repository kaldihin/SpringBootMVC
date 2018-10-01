package com.example.demo.views;

import io.swagger.annotations.ApiModelProperty;
import com.example.demo.models.Doc;

public class DocView {

    @ApiModelProperty(hidden = true)

    public String name;

    public Integer code;

    public DocView() {}

    public DocView(Doc doc) {
        this.name = doc.getName();
        this.code = doc.getCode();
    }

    @Override
    public String toString() {
        return "{doc_name:" + name + ";doc_code:" + code + "}";
    }
}