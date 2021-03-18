package com.uycode.mockapiserver.controller;

import com.uycode.mockapiserver.common.utils.ResponseUtils;
import com.uycode.mockapiserver.entity.ResponseEntity;
import com.uycode.mockapiserver.entity.User;
import com.uycode.mockapiserver.service.FilesService;
import com.uycode.mockapiserver.service.UserService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-15
 */
@RestController
@RequestMapping("/files")
public class FilesController {

    @Resource
    UserService userService;
    @Resource
    FilesService filesService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(String userEmail, MultipartFile[] files) {

        if (CollectionUtils.isEmpty(Arrays.asList(files.clone()))) {
            return ResponseUtils.fail("文件不能为空");
        }
        if (userEmail.isEmpty()) {
            return ResponseUtils.fail("无法获取用户信息");
        }
        return ResponseUtils.success(filesService.saveFile(userEmail, files));

    }

    @PostMapping("/getFiles")
    public ResponseEntity<?> getFiles(@RequestBody User user) {

        String userEmail = user.getEmail();
        if (ObjectUtils.isEmpty(userEmail)) {
            return ResponseUtils.fail("用户账户不存在");
        }
        User user1 = userService.getUserByEmail(user.getEmail());
        if (ObjectUtils.isEmpty(user1)) {
            return ResponseUtils.fail("无法获取用户信息");
        }

        return ResponseUtils.success(filesService.getFilesByUserId(user1.getId()));

    }

}
