package com.example.demo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "list", nickname = "list", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/organization/list")
    public Map<String, Object> list(@Valid @RequestBody OrganizationViewList viewList, BindingResult result ) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","false");
        }else{
            map.put("Data",organizationService.list(viewList));
        }
        return map;
    }

    //  organization{id} get

    @ApiOperation(value = "organization", nickname = "organization", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/organization/organization{id}")
    public OrganizationView organization(@PathVariable("id") Integer id) {
        return organizationService.getById(id);
    }

    //  update post

    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/organization/update")
    public Map<String, Object> update (@Valid @RequestBody OrganizationViewUpdate view, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","false");
        }else{
            organizationService.update(view);
            map.put("result","success");
        }
        return map;
    }

    //  save post

    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @PostMapping("/organization/save")
    public Map<String, Object> save (@Valid @RequestBody OrganizationViewSave viewSave, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","false");
        }else{
            organizationService.save(viewSave);
            map.put("result","success");
        }
        return map;
    }
}
