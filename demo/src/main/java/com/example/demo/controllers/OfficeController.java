package com.example.demo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.serviceinterfaces.OfficeService;
import com.example.demo.views.OfficeView;
import com.example.demo.views.OfficeViewList;
import com.example.demo.views.OfficeViewSave;
import com.example.demo.views.OfficeViewUpdate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    //  list{orgId} post

    @ApiOperation(value = "list", nickname = "list", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/office/list/{orgId}")
    public Map<String, Object> list(@Valid @PathVariable Integer orgId, @RequestBody OfficeViewList org, BindingResult result) {
        org.setId(orgId);
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","false");
        }else{
            map.put("Data",officeService.list(org, orgId));
        }
        return map;
    }

    //  {id} get

    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @GetMapping("/office/{id}")
    public OfficeView byId(@PathVariable("id") Integer id) {
        return officeService.getById(id);
    }

    //  update post

    @ApiOperation(value = "update", nickname = "update", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/office/update")
    public Map<String, Object> update(@Valid @RequestBody OfficeViewUpdate officeViewUpdate, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","false");
        }else{
            officeService.update(officeViewUpdate);
            map.put("result","success");
        }
        return map;
    }

    //  save post

    @ApiOperation(value = "save", nickname = "save", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/office/save")
    public Map<String, Object> save(@Valid @RequestBody OfficeViewSave officeViewSave, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","false");
        }else{
            officeService.save(officeViewSave);
            map.put("result","success");
        }
        return map;
    }
}
