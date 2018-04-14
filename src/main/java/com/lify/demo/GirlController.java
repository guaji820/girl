package com.lify.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/")
    public String addGirl(@RequestParam(value = "age", required = false) Integer age, @RequestParam(value = "cupSize", required = false) String cupSize) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl).toString();
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
    public void addTwoGirls(){
        girlService.insertTwo();
    }
}
