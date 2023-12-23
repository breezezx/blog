package org.zx.blog.service.impl;

import org.zx.blog.entity.Blog;
import org.zx.blog.mapper.BlogMapper;
import org.zx.blog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
