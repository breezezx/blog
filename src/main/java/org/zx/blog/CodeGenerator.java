package org.zx.blog;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://bj-cynosdbmysql-grp-8xfntq6u.sql.tencentcdb.com:21445/blog?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai",
                "root","251968840Zx")
                //全局配置
                .globalConfig(builder -> {
                    builder.author("zhangxin")
                            .commentDate("yyyy-MM-dd hh:mm:ss")
                            .outputDir(System.getProperty("user.dir")+"/src/main/java")
                            .disableOpenDir();
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("org.zx.blog")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,System.getProperty("user.dir")+"/src/main/resources/mappers"));//设置mapperxml文件生成路径
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("m_user","m_blog")//设置需要生成的表名
                            .addTablePrefix("m_")
                            .entityBuilder()
                            .enableLombok()
                            .enableFileOverride()
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            // Mapper 策略配置
                            .mapperBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            // Service 策略配置
                            .serviceBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            // Controller 策略配置
                            .controllerBuilder()
                            .enableFileOverride();// 覆盖已生成文件
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
