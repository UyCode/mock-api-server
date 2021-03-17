package com.uycode.mockapiserver.controller;

import com.uycode.mockapiserver.common.utils.ResponseUtils;
import com.uycode.mockapiserver.entity.ResponseEntity;
import com.uycode.mockapiserver.service.FilesService;
import com.uycode.mockapiserver.service.UserService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
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

}
