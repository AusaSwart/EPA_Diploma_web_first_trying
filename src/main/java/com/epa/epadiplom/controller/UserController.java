package com.epa.epadiplom.controller;

import com.epa.epadiplom.service.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// here's we mapping pages we needed
@Controller
@RequestMapping("/")
@ComponentScan(basePackages={"com.epa.epadiplom.service"})
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/list_of_job_titles")
    public String listOfJobTitles(Model model){
        model.addAttribute("job_title", userService.findAll());
        return "list_of_job_titles";
    }

}
