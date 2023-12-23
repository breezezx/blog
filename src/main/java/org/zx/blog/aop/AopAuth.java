package org.zx.blog.aop;


import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAuth {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(org.zx.blog.aop.Auth)")//表示从annotation切入
    public void pointcut(){

    }
    @Before("pointcut()&&@annotation(auth)")//这个就是看pointcut是不是auth这个切入点
    public void before(JoinPoint joinPoint,Auth auth)throws Exception{

        if(auth.role().equals("admin")){
            String token = request.getHeader("Authorization");
            System.out.println("权限校验不通过");
            throw new Exception("权限校验不通过");
        }
        request.setAttribute("权限检查", "true");
        return;
    }
}
