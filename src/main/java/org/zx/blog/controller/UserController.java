package org.zx.blog.controller;

import cn.hutool.db.sql.Wrapper;
import cn.hutool.json.JSON;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.zx.blog.aop.Auth;
import org.zx.blog.common.lang.Result;
import org.zx.blog.entity.User;
import org.zx.blog.service.UserService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangxin
 * @since 2023-12-17 02:49:50
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Auth
    @GetMapping("/{id}")
    public Object test(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User userinfo){
//        这部分是常规的mybatis查数据然后生成一个jwt给前端完成登录
//        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
//        HashMap<String ,Object> map=new HashMap<>();
//        map.put("username",userinfo.getUsername());
//        map.put("password",userinfo.getPassword());
//        System.out.println(map);
//        queryWrapper.allEq(map);
//        User user = userService.getOne(queryWrapper);
//        if(user !=null){
//            //登录成功
//            HashMap<String ,Object> tokenmap =new HashMap<>();
//            tokenmap.put("username",userinfo.getUsername());
//            tokenmap.put("logintime",new Date());
//            String token = JWTUtil.createToken(tokenmap,"zhangxin".getBytes());
//            return Result.succ("登录成功",token);
//
//        }
//        return Result.fail("输入的用户信息不正确");
        Subject currentUser= SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token= new UsernamePasswordToken(userinfo.getUsername(),userinfo.getPassword());
            token.setRememberMe(true);
            currentUser.login(token);
        }

    }

    @Auth(role = "admin")
    @GetMapping("/changePwd")
    public Object changePwd(){
        return Result.succ("修改密码成功",null);
    }
}
