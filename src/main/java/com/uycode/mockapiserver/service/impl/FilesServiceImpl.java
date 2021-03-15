package com.uycode.mockapiserver.service.impl;

import com.uycode.mockapiserver.entity.Files;
import com.uycode.mockapiserver.mapper.FilesMapper;
import com.uycode.mockapiserver.service.FilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
