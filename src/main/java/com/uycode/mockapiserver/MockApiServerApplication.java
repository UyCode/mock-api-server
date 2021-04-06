package com.uycode.mockapiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hyper
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.uycode.mockapiserver.mapper"})
public class MockApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockApiServerApplication.class, args);
    }

}
