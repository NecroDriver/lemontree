package com.xin.lemontree;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author creator mafh 2017/12/18 13:53
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String say(){
        return "hello world!";
    }

    @RequestMapping("/call")
    public String call(){
        return "call world! this is spring boot. I'm test jrebel.";
    }
}
