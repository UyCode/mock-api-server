package com.uycode.mockapiserver.service.impl;

import com.uycode.mockapiserver.entity.SysUser;
import com.uycode.mockapiserver.mapper.SysUserMapper;
import com.uycode.mockapiserver.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
