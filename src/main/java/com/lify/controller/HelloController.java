package com.lify.controller;

import com.lify.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController = @Controller + @ResponseBody
@Controller
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    //如果有多个 状态都可以映射到一个 方法的话，可以加一个集合的方式来 写value
    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)//也可以统一提到类名上去写
    public String say() {
        //return girlProperties.getCupSize();//"123";////"hello springboot${cupSize}".concat(content);//这样是 不行的， 在配置和value里可以通过 $cupSize
        return "index";
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public String say2() {
        return "good bye!!!";
    }
}
