package com.uycode.mockapiserver.controller;

import com.uycode.mockapiserver.common.utils.ResponseUtils;
import com.uycode.mockapiserver.dto.UserFileDto;
import com.uycode.mockapiserver.entity.Files;
import com.uycode.mockapiserver.entity.ResponseEntity;
import com.uycode.mockapiserver.entity.User;
import com.uycode.mockapiserver.service.FilesService;
import com.uycode.mockapiserver.service.UserService;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

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

    private String baseDir = "\\storage\\imgs\\";

    @PostMapping("/upload")
    public ResponseEntity uploadFile(String userEmail, MultipartFile file) throws IOException {



        File projectDir = new File(ResourceUtils.getURL("").getPath());

        String fileName = file.getOriginalFilename();

        File storageDir = new File(ResourceUtils.getURL(projectDir + baseDir).getPath());
        if(!storageDir.exists()) {
            System.out.println("正在创建本地存储目录......");
            storageDir.mkdirs();
            System.out.println("已创建本地存储目录: " + storageDir);
        }

        //assert fileName != null;
        file.transferTo(new File(projectDir + baseDir + fileName));

        Files files = new Files();
        files.setFileName(fileName);
        files.setFilePath((projectDir + baseDir + fileName));
        files.setFileStatus(0);
        User user = userService.getUserByEmail(userEmail);
        files.setUserId(user.getId());

        filesService.saveFile(files);
        UserFileDto userFileDto = new UserFileDto();
        userFileDto.setUserEmail(userEmail);
        userFileDto.setUserName(user.getUsername());
        userFileDto.setFilePath(files.getFilePath());
        userFileDto.setFileName(files.getFileName());
        userFileDto.setFileStatus(files.getFileStatus());

        return ResponseUtils.success(userFileDto);
    }

}
