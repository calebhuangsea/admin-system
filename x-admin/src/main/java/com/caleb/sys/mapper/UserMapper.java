package com.caleb.sys.mapper;

import com.caleb.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caleb
 * @since 2023-10-01
 */
public interface UserMapper extends BaseMapper<User> {

    public List<String> getRoleNamesByUserId(Integer userId);

}
