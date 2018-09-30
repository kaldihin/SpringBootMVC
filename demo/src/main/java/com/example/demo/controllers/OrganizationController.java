package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.serviceinterfaces.OrganizationService;
import com.example.demo.views.OrganizationView;
import com.example.demo.views.OrganizationViewList;
import com.example.demo.views.OrganizationViewSave;
import com.example.demo.views.OrganizationViewUpdate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    //  list post

    @GetMapping("/organization/list")
    @ResponseBody
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        List<OrganizationViewList> list = organizationService.list();
                map.put("data", list);
            return map;
    }

    //  organization{id} get


    @GetMapping("/organization/{id}")
    public Map<String, Object> organization(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", organizationService.getById(id).toString());
        return map;
    }

    //  update post


    @PostMapping("/organization/update")
    public Map<String, Object> update (@Valid @RequestBody OrganizationViewUpdate viewUpdate, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","error");
        }else{
            organizationService.update(viewUpdate);
            map.put("result","success");
        }
        return map;
    }

    //  save post


    @PostMapping("/organization/save")
    public Map<String, Object> save (@Valid @RequestBody OrganizationViewSave viewSave, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (!result.hasErrors()) {
            organizationService.save(viewSave);
            map.put("result", "success");
        }else {
            map.put("result", "error");
        }
        return map;
    }
}
