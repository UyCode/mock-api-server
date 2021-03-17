package com.uycode.mockapiserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uycode.mockapiserver.common.exception.MessageException;
import com.uycode.mockapiserver.dto.UserFileDto;
import com.uycode.mockapiserver.entity.Files;
import com.uycode.mockapiserver.entity.User;
import com.uycode.mockapiserver.mapper.FilesMapper;
import com.uycode.mockapiserver.service.FilesService;
import com.uycode.mockapiserver.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-15
 */
@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, Files> implements FilesService {

    @Resource
    FilesMapper filesMapper;
    @Resource
    UserService userService;


    private String baseDir = "\\storage\\imgs\\";

    @Override
    public boolean saveFile(String userEmail, MultipartFile[] allFiles) {
        for (MultipartFile file : allFiles) {
            try {
                File projectDir = new File(ResourceUtils.getURL("").getPath());
                String fileName = file.getOriginalFilename();
                File storageDir = new File(ResourceUtils.getURL(projectDir + baseDir).getPath());

                assert fileName != null;
                if (fileName.isEmpty()) {
                    return false;
                }
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);


                if (!storageDir.exists()) {
                    System.out.println("正在创建本地存储目录......");
                    storageDir.mkdirs();
                    System.out.println("已创建本地存储目录: " + storageDir);
                }

                file.transferTo(new File(projectDir + baseDir + fileName));


                Files files = new Files();
                files.setFileName(fileName);
                files.setFilePath((projectDir + baseDir + fileName));
                files.setFileStatus(0);
                User user = userService.getUserByEmail(userEmail);
                files.setUserId(user.getId());


                UserFileDto userFileDto = new UserFileDto();
                userFileDto.setUserEmail(userEmail);
                userFileDto.setUserName(user.getUsername());
                userFileDto.setFilePath(files.getFilePath());
                userFileDto.setFileName(files.getFileName());
                userFileDto.setFileStatus(files.getFileStatus());
                filesMapper.insert(files);
            } catch (Exception e) {
                log.error("无法上传文件");
                throw new MessageException(e.getMessage());
            }
        }
        return true;
    }

}
