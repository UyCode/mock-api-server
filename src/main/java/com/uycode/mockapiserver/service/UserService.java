package com.uycode.mockapiserver.service;

import com.uycode.mockapiserver.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uycode.mockapiserver.mapper.UserMapper;
import com.uycode.mockapiserver.service.impl.UserServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-14
 */
public interface UserService extends IService<User> {


    List<User> getAllUser();

    User getUserByEmailAndPassword(String email, String password);


}
