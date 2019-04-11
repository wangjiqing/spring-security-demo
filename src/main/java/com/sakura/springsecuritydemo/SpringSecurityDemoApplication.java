package com.sakura.springsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    /**
     * 访问主路径放行 http://localhost:8080/
     * @return
     */
    @RequestMapping("/")
    public String home() {
        return "Hello Spring Boot!";
    }

    /**
     * 访问其它请求 http://localhost:8080/hello 需要的登录
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    /**
     * 这里开启一个只能用ADMIN角色访问的URL
     * 当使用 admin 用户登录的时候访问 /roleAuth 的时候可以通过
     * 当使用 demo 用户登录的时候访问 /roleAuth 的时候不可达
     * 使用此注解的时候需要在该类上开启 EnableGlobalMethodSecurity(prePostEnabled = true) 注解
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/roleAuth")
    public String role() {
        return "admin auth";
    }
}
