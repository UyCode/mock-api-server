package com.uycode.mockapiserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.uycode.mockapiserver.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-14
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //List<User> selectList(Wrapper<User> queryWrapper);

}
