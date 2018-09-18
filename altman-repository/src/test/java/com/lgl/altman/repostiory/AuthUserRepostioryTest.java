package com.lgl.altman.repostiory;

import com.lgl.altman.entity.AuthUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserRepostioryTest {

    @Autowired
    AuthUserRepostiory authUserRepostiory;
    @Test
    public void add(){
        AuthUser authUser = new AuthUser();
        authUser.setUserName("第一个用户");
        authUser.setPassWord("我是MD5");
        authUser.setAge(1);
        authUserRepostiory.save(authUser);
    }
}