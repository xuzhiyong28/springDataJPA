package com.springdatajpa.service.Impl;/**
 * Created by Administrator on 2017/8/1.
 */

import com.springdatajpa.dao.UserInfoRepository;
import com.springdatajpa.domain.UserInfo;
import com.springdatajpa.service.UserSerivce;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzhiyong
 * @createDate 2017-08-01-15:05
 */
@Service("userService")
public class UserServiceImpl implements UserSerivce {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    public void addUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    public void updateUser(UserInfo userInfo) {
        UserInfo userInfo1 = userInfoRepository.findOne(userInfo.getUid());
        if (userInfo1 != null) {
            userInfo1.setUsername(userInfo.getUsername());
            userInfo1.setName(userInfo.getName());
            userInfo1.setSalt(userInfo.getSalt());
            userInfo1.setState(userInfo.getState());
            userInfoRepository.save(userInfo1);
        }
    }

    public List<UserInfo> findByUid(Long uid) {
        return userInfoRepository.findByUid(uid);
    }

    public List<UserInfo> findByNameStartingWithAndUsernameContaining(String name, String userName) {
        return userInfoRepository.findByNameStartingWithAndUsernameContaining(name, userName);
    }

    public List<UserInfo> findUserInfoInUid(Long uid) {
        return userInfoRepository.findUserInfoInUid(uid);
    }

    public List<UserInfo> findUserInName(String name) {
        return userInfoRepository.findUserInName(name);
    }

    public int updateUserInfoNameByUid(String newName, Long uid) {
        return userInfoRepository.updateUserInfoNameByUid(newName, uid);
    }

    public List<UserInfo> findTop2ByName(String name) {

        /*userInfoRepository.findTop2ByUid(uid , new Sort(Sort.Direction.ASC,"uid"));*/
        /*
            Sort.Order order = new Sort.Order(Sort.Direction.ASC,"uid");
            userInfoRepository.findTop2ByUid(uid,new Sort(order));
        */
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.ASC, "uid");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "name");
        orders.add(order1);
        orders.add(order2);
        return userInfoRepository.findTop2ByName(name, new Sort(orders));
    }

    //分页
    public Page<UserInfo> findByName(String name, Integer page, Integer pageSize) {
        return userInfoRepository.findByName(name , new PageRequest(page,pageSize));
    }
}
