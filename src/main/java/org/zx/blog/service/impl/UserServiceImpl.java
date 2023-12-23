package org.zx.blog.service.impl;

import org.zx.blog.entity.User;
import org.zx.blog.mapper.UserMapper;
import org.zx.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangxin
 * @since 2023-12-17 02:49:50
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
