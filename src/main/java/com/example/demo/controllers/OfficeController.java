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

    @GetMapping("/office/list/{orgId}")
    @ResponseBody
    public Map<String, Object> list(@PathVariable Integer orgId) {
        Map<String, Object> map = new HashMap<>();
            map.put("Data",officeService.list(orgId));
        return map;
    }

    //  {id} get

    @GetMapping("/office/{id}")
    @ResponseBody
    public OfficeView byId(@PathVariable("id") Integer id) {
        return officeService.getById(id);
    }

    //  update post


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
