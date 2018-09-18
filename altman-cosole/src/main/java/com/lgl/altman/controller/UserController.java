package com.lgl.altman.controller;

import com.lgl.altman.entity.AuthUser;
import com.lgl.altman.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthUserService authUserService;
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login.do" )
    @ResponseBody
    public  Map<String ,String > login(@RequestParam String username, @RequestParam String password){
        System.out.println("进入login.do");
        System.out.println("name:"+username);
        System.out.println("password:"+password);
        AuthUser user=  authUserService.findUserName(username);
        System.out.println(user.getUserName());
        Map<String ,String > map = new HashMap<String, String>();
        map.putIfAbsent("name",username);
        return map;

    }
}
