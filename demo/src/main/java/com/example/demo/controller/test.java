package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// for Testing   http://localhost:9003/test/user/134
@RestController
@RequestMapping(value = "/test")
public class test {

    @GetMapping("/user/{id}")
    @ResponseBody
    public int testing(@PathVariable int id) {
        try{
            System.out.println("************ working fine dude ******************"+ id);
            return 1;
        } catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }
    
}
