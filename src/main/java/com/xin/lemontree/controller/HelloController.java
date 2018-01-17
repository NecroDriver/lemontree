package com.xin.lemontree.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author creator mafh 2017/12/18 13:53
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "hello world!";
    }

    @RequestMapping(value = "/call", method = RequestMethod.POST)
    public String call() {
        return "call world! this is spring boot. I'm test jrebel.";
    }
}
