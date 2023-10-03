package com.caleb.sys.service.impl;

import com.caleb.sys.entity.Menu;
import com.caleb.sys.mapper.MenuMapper;
import com.caleb.sys.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
