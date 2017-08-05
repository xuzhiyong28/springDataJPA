package com.springdatajpa.dao;/**
 * Created by Administrator on 2017/8/2.
 */

import com.springdatajpa.domain.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author xuzhiyong
 * @createDate 2017-08-02-11:33
 * 在编写spring data jpa的dao时,只需在接口中按规约提供方法的声明即可.而有些业务实现无法通过声明方法或编写简单的SQL实现,这就需要扩展Spring Data JPA
 */
//这里的命名必须是UserInfoRepository + Impl 不能是 UserInfoDao + Impl
public class UserInfoRepositoryImpl implements UserInfoDao {
    //获取当前线程的EntityManager实例
    @PersistenceContext
    private EntityManager entityManager;

    public void method() {
        UserInfo userInfo = entityManager.find(UserInfo.class, 6L);
    }
}
