package com.springdatajpa.service;/**
 * Created by Administrator on 2017/8/1.
 */

import com.springdatajpa.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author xuzhiyong
 * @createDate 2017-08-01-15:05
 */
public interface UserSerivce {
    public List<UserInfo> findAll();
    public void addUser(UserInfo userInfo);
    public void updateUser(UserInfo userInfo);
    List<UserInfo> findByUid(Long uid);
    List<UserInfo> findByNameStartingWithAndUsernameContaining(String name ,String userName);
    List<UserInfo> findUserInfoInUid(Long uid);
    List<UserInfo> findUserInName(String name);
    public int updateUserInfoNameByUid(String newName , Long uid);
    List<UserInfo> findTop2ByName(String name);
    Page<UserInfo> findByName(String name , Integer page , Integer pageSize);
}
