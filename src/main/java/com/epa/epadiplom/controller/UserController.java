package com.epa.epadiplom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// here's we mapping pages we needed
@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
