package com.example.demo.controllers;

import com.example.demo.views.DocView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.serviceinterfaces.DocService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class DocController {

    private final DocService docService;

    @Autowired
    public DocController(DocService docService) {
        this.docService = docService;
    }

    @PostMapping("/docs")
    public Map<String, Object> getDocs() {
        Map<String, Object> map = new HashMap<>();
        List<DocView> list = docService.docs();
        map.put("data",list);
        return map;
    }

}
