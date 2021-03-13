package com.uycode.mockapiserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ahmatjan
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String greet() {
        return "Welcome to Mock data generator";
    }
}
