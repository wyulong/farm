package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xhua
 * @Date 2020/3/22 0:20
 **/
public interface UserMapper extends BaseMapper<User> {

    User selectUserByToken(@Param("token") String token);
}
