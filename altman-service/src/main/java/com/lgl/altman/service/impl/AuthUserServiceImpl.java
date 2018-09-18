package com.lgl.altman.service.impl;

import com.alibaba.fastjson.JSON;
import com.lgl.altman.entity.AuthUser;
import com.lgl.altman.repostiory.AuthUserRepostiory;
import com.lgl.altman.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthUserRepostiory authUserRepostiory;

    @Override
    public AuthUser save(AuthUser authUser) {
        authUser = authUserRepostiory.save(authUser);
        return authUser;
    }

    @Override
    public AuthUser findOneByUserId(Long userId) {
        AuthUser authUser = authUserRepostiory.getOne(userId);
        return authUser;
    }

    @Override
    public AuthUser findUserName(String userName) {
        AuthUser authUser = authUserRepostiory.findByUserName(userName);
        return authUser;
    }

    @Override
    public List<AuthUser> findALL(Integer page, Integer size) {
        if (null == page || page < 0) page = 0;
        if (null == size) size = 10;

        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<AuthUser> obj = authUserRepostiory.findAll(pageable);
        System.err.println(JSON.toJSONString(obj));
        return obj.getContent();
    }

    @Override
    public List<AuthUser> findALL() {
        List<AuthUser> list = authUserRepostiory.findAll();
        return list;
    }

    @Override
    public List<AuthUser> findByAuthUserName(String userName, Integer page, Integer size) {
        if (null == page || page < 0) page = 0;
        if (null == size) size = 10;
        Specification<AuthUser> specification = new Specification<AuthUser>() {
            @Override
            public Predicate toPredicate(Root<AuthUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (null != userName && !"".equals(userName)) {
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), userName));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<AuthUser> obj = authUserRepostiory.findAll(specification, pageable);
        System.err.println(JSON.toJSONString(obj));
        return obj.getContent();
    }
}
