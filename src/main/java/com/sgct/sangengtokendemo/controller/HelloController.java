package com.sgct.sangengtokendemo.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test")
    @PreAuthorize("hasAnyAuthority('system:dept:list')")
    public String hello() {
        return "hello world";
    }
}
