package com.caleb.sys.service.impl;

import com.caleb.sys.entity.User;
import com.caleb.sys.mapper.UserMapper;
import com.caleb.sys.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
