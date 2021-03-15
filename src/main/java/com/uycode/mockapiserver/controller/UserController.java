package com.uycode.mockapiserver.controller;


import com.uycode.mockapiserver.common.utils.ResponseUtils;
import com.uycode.mockapiserver.entity.ResponseEntity;
import com.uycode.mockapiserver.entity.User;
import com.uycode.mockapiserver.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping ("/getAllUser")
    public List<User> getAllUsers(@RequestBody(required = false) User user){
        System.out.println(user.getEmail());
        return userService.getAllUser();
    }

    @PostMapping("/login")
    public ResponseEntity<User> getExactUser(@RequestBody User user, @RequestParam String userName){
        String email = user.getEmail();
        String password = user.getPassword();

        System.out.println(email + password);
        System.out.println(userName);


        User result = userService.getUserByEmailAndPassword(email, password);
        System.out.println(result);

        return ResponseUtils.success(userService.getUserByEmailAndPassword(email, password));
    }
}
