package com.uycode.mockapiserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmatjan
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/index")
    public String greet() {
        return "Welcome to Mock data generator";
    }
}
