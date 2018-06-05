package com.lify.controller;

import com.lify.domain.Girl;
import com.lify.domain.ResponseData;
import com.lify.repository.GirlRepository;
import com.lify.service.GirlService;
import com.lify.util.ResponseDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/girl")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * @PostMapping(value = "/")
     * public String addGirl(@RequestParam(value = "age", required = false) Integer age, @RequestParam(value = "cupSize", required = false) String cupSize) {
     * Girl girl = new Girl();
     * girl.setAge(age);
     * girl.setCupSize(cupSize);
     * return girlRepository.save(girl).toString();
     * }
     */
    @PostMapping(value = "/")
    public ResponseData<Girl> addGirl(@RequestBody @Valid Girl girl, BindingResult bindingResult) {//接收json参数//加了 @Valid验证以后，可以加个参数看到验证结果
        if (bindingResult.hasErrors()) {
            return ResponseDataUtil.fail(-1, bindingResult.getFieldError().getDefaultMessage());
        } else {
            girl.setAge(girl.getAge());
            girl.setCupSize(girl.getCupSize());
            return ResponseDataUtil.success(girlRepository.save(girl));
        }
    }


    @PutMapping(value = "/{id}")
    public String updateGirl(@PathVariable(value = "id", required = true) Integer id, @RequestParam(value = "age", required = false) Integer age, @RequestParam(value = "cupSize", required = false) String cupSize) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl).toString();
    }

    @PostMapping(value = "/twogirls")
    public void addTwoGirls() {
        girlService.insertTwo();
    }

    // http://localhost:8080/demo/girl/getAge/{id}
    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
