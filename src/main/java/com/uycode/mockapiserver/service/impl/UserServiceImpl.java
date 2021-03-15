package com.uycode.mockapiserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.uycode.mockapiserver.entity.User;
import com.uycode.mockapiserver.enums.UserStatus;
import com.uycode.mockapiserver.mapper.UserMapper;
import com.uycode.mockapiserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> getAllUser() {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username", "a");

        return userMapper.selectList(wrapper);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("email", email);
        queryWrapper.eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        if(UserStatus.USER_STATUS_BANNED.equals(user.getStatus())) {

        }
        return user;
    }


}
