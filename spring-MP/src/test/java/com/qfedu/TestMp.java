package com.qfedu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.dao.UserDao;
import com.qfedu.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/24 10:56
 * description:
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mp.xml")
public class TestMp {
    @Autowired
    UserDao userDao;

    @Test
    public void testInsert(){
        User user=new User();

        user.setPassword("123");
        user.setUserName("taotie");
        user.setName("青龙");
        user.setId(12L);
        user.setAge(20);
        user.setEmail("test1@1000phone.com");
        userDao.insert(user);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id","10");
        user.setName("梼杌");

        int result=userDao.update(user,queryWrapper);
        System.out.println("result="+result);
    }
    @Test
    public void testDeleteById(){
        User user=new User();
        int result=userDao.deleteById(10L);
        System.out.println("result="+result);

    }
    @Test
    public void testSelectById(){
        User user=new User();
        user=userDao.selectById(1L);
        System.out.println("user="+user);
    }
    @Test
    public void testSelectOne(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("name","玄武");
        User user=userDao.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void testWrapper(){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        Map<String,Object> params=new HashMap<>();

        params.put("name","饕餮");
        params.put("age","24");
        params.put("password",null);

        queryWrapper.allEq(params);

        List<User> users=userDao.selectList(queryWrapper);
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testWrapperOr(){
        QueryWrapper<User> wrapper=new QueryWrapper<>();

        wrapper.eq("name","青龙").or().eq("age",10);
        List<User> users=userDao.selectList(wrapper);
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testWrapperOrder(){
        QueryWrapper queryWrapper=new QueryWrapper<>();


    }
}
