package com.springdatajpa.dao;/**
 * Created by Administrator on 2017/8/1.
 */

import com.springdatajpa.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xuzhiyong
 * @createDate 2017-08-01-15:06
 * 方法名构造 ： find + 全局修饰 + By + 实体的属性名称 + 限定词 + 连接词 + ...(其他属性) + OrderBy + 排序属性 + 排序方向
 * 例子 findDistinctByFirstNamelgnoreCaseAndLastNameOrderByAgeDesc(String firstName , String lastName)
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> , UserInfoDao<UserInfo,Long>{
    //采用JPA方法规范命名方法
    List<UserInfo> findByUid(Long uid);
    List<UserInfo> findByNameStartingWithAndUsernameContaining(String name ,String userName);
    List<UserInfo> findTop2ByName(String name , Sort sort); //找前面2条并排序
    Page<UserInfo> findByName(String name,Pageable pageable);






    //采用@Query方式的查询
    @Query("select o from UserInfo o where o.uid =?1")
    List<UserInfo> findUserInfoInUid(Long uid);

    @Query("select o from UserInfo  o where o.name like %:name%")
    List<UserInfo> findUserInName(@Param("name") String name);


    @Modifying
    @Transactional //更新删除操作需要事务支持，不然会报错
    @Query("update UserInfo  o set o.name=:newName where o.uid = :uid")
    public int updateUserInfoNameByUid(@Param("newName") String newName ,@Param("uid") Long uid);




}
