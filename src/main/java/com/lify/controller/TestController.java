package com.lify.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return "" + id;
    }

    @RequestMapping(value = "/say", method = RequestMethod.POST)
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id, @RequestParam(value = "name") String name) {//RequestParam要的是表单类型的参数
        return "@RequestParam:" + id + name;
    }

//    @RequestMapping(value = "/rb", method = RequestMethod.POST)
//    public String rb() {//RequestParam要的是表单类型的参数
//        return "@RequestParam:" + id + name;
//    }

//    @GetMapping  @RequestMapping method=Request.GET的简写
//    @PostMapping
}