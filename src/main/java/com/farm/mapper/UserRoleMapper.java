package com.farm.mapper;

import com.farm.dto.res.RoleModuleDTO;
import com.farm.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色权限表 Mapper 接口
 * </p>
 *
 * @author wyulong
 * @since 2020-03-27
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<RoleModuleDTO> getMenuByUserType(@Param("type") Integer type);

}
