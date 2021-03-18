package com.uycode.mockapiserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uycode.mockapiserver.entity.Files;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-15
 */
public interface FilesService extends IService<Files> {

    boolean saveFile(String userEmail, MultipartFile[] files);

    List<Files> getFilesByUserId(int userId);

}
