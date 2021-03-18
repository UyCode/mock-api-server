package com.uycode.mockapiserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uycode.mockapiserver.entity.Files;
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

    /**
     * 根据userId获取附件
     * @param userId
     * return
     * */
    //List<Files> getFilesByUserId(@Param("userId") int userId);
}
