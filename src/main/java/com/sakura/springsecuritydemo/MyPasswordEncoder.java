package com.sakura.springsecuritydemo;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码加密管理器
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {

        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
