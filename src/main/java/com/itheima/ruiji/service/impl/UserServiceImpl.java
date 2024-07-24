package com.itheima.ruiji.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.ruiji.entity.User;
import com.itheima.ruiji.mapper.UserMapper;
import com.itheima.ruiji.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
