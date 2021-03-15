package com.uycode.mockapiserver.mapper;

import com.uycode.mockapiserver.entity.Files;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ahmatjan
 * @since 2021-03-15
 */
@Repository
@Mapper
public interface FilesMapper extends BaseMapper<Files> {

}
