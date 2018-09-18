package com.lgl.altman.service;

import com.lgl.altman.entity.AuthUser;

import java.util.List;

public interface AuthUserService {
    public AuthUser save(AuthUser authUser);
    public AuthUser findOneByUserId(Long userId);
    public AuthUser findUserName(String userName);
    public List<AuthUser> findALL(Integer page,Integer size);
    public List<AuthUser> findALL();
    public List<AuthUser> findByAuthUserName(String userName,Integer page, Integer size);

}
