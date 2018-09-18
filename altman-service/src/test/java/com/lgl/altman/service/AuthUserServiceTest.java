package com.lgl.altman.service;

import com.alibaba.fastjson.JSON;
import com.lgl.altman.entity.AuthUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserServiceTest {

    @Autowired
    AuthUserService authUserService;
    @Test
    public void save() {
        for (int i=0;i<10;i++){
            AuthUser authUser= new AuthUser();
            authUser.setUserName("userName_"+i);
            authUser.setPassWord("password_"+i);
            authUser.setAge(i);
            authUserService.save(authUser);
        }
    }

    @Test
    public void findOneByUserId() {
        Long userID= 11l;
        AuthUser authUser=   authUserService.findOneByUserId(userID);
        if(null==authUser){
            System.out.println("我是null");
        }
//        System.err.println(JSON.toJSONString(authUser));

    }

    @Test
    public void findALL() {
       List<AuthUser> list= authUserService.findALL();
        System.out.println(list.size());
    }

    @Test
    public void findALL1() {
    }

    @Test
    public void findByAuthUserName() {
    }
    @Test
    public void findByUserName() {
        System.out.println( authUserService.findUserName("userName_0").getUserName());
    }
}