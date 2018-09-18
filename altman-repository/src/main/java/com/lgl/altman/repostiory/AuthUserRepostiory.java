package com.lgl.altman.repostiory;

import com.lgl.altman.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AuthUserRepostiory extends JpaRepository<AuthUser,Long>, JpaSpecificationExecutor<AuthUser> {
    AuthUser findByUserName(String username);

}
