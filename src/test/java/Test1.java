/**
 * Created by Administrator on 2017/8/1.
 */

import com.springdatajpa.dao.LearnResourceRepository;
import com.springdatajpa.dao.UserInfoRepository;
import com.springdatajpa.domain.LearnResource;
import com.springdatajpa.domain.UserInfo;
import com.springdatajpa.service.UserSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuzhiyong
 * @createDate 2017-08-01-15:28
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class Test1 {

    @Resource(name = "userService")
    private UserSerivce userSerivce;


    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private LearnResourceRepository learnResourceRepository;


    @Test
    public void testOne(){
        List<UserInfo> userList = userSerivce.findAll();
        System.out.println(userSerivce);
    }

    @Test
    public void testTwo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("JPA测试");
        userInfo.setUsername("jpaUsername");
        userSerivce.addUser(userInfo);
    }

    @Test
    public void test3(){
        List<UserInfo> list = userSerivce.findByUid((long) 6);
    }

    @Test
    public void test4(){
        userSerivce.findUserInfoInUid(6L);
    }

    @Test
    public void test5(){
        userSerivce.findUserInName("许");
    }

    @Test
    public void test6(){
        userSerivce.updateUserInfoNameByUid("柳英英",6L);
    }

    @Test
    public void test7(){
        userInfoRepository.method();
    }

    @Test
    public void test8(){
        userSerivce.findTop2ByName("许志勇");
    }

    @Test
    public void test9(){
        Page<LearnResource> pageModel = learnResourceRepository.findAll(new PageRequest(1,15));
        System.out.println("当前第几页 = " + pageModel.getNumber());
        System.out.println("当前页查得的记录数 = " + pageModel.getNumberOfElements());
        System.out.println("每页需要查询的条数 = " + pageModel.getSize());
        System.out.println("总条数 = " + pageModel.getTotalElements());
        System.out.println("总页数 = " + pageModel.getTotalPages());
    }

}
