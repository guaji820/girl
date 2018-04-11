package com.lify.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${content}")
//    private String content;

    @Autowired
    private Girl girlProperties;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize();//"123";////"hello springboot${cupSize}".concat(content);//这样是 不行的， 在配置和value里可以通过 $cupSize
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public String say2() {
        return "good bye!!!";
    }
}
