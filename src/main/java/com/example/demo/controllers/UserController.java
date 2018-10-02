package com.example.demo.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.serviceinterfaces.UserService;
import com.example.demo.views.UserView;
import com.example.demo.views.UserViewList;
import com.example.demo.views.UserViewSave;
import com.example.demo.views.UserViewUpdate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    list get


    @GetMapping("/user/list")
    @ResponseBody
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", userService.list());
        return map;
    }

    //    user/{id} get


    @GetMapping("/user/{id}")
    @ResponseBody
    public Map<String, Object> user(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", userService.getUser(id));
        return map;
    }

//    update post


    @PostMapping("/user/update")
    public Map<String, Object> update(@Valid @RequestBody UserViewUpdate user, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","error");
        }else{
            userService.update(user);
            map.put("result","success");
        }
        return map;
    }
//    save post

    @PostMapping("/user/save")
    public Map<String, Object> save(@Valid @RequestBody UserViewSave user, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()) {
            map.put("result","error");
        }else{
            userService.save(user);
            map.put("result","success");
        }
        return map;
    }

}
