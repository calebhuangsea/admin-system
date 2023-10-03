package com.caleb.sys.service.impl;

import com.caleb.sys.entity.Role;
import com.caleb.sys.mapper.RoleMapper;
import com.caleb.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caleb
 * @since 2023-10-01
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
