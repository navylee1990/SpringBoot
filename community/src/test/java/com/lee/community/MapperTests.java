package com.lee.community;

import com.lee.community.dao.DiscussPostMapper;
import com.lee.community.dao.UserMapper;
import com.lee.community.entity.DiscussPost;
import com.lee.community.entity.User;
import com.lee.community.service.DiscussPostService;
import com.lee.community.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = com.lee.community.CommunityApplication.class)
@SpringBootTest
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void TestSelectById(){
        User user=userService.findUserById(103);
        List<DiscussPost> lists =discussPostService.findDiscussPosts(101,0,10);
        for(DiscussPost list:lists){
            System.out.println(list);
        }
        System.out.println("rows:"+discussPostMapper.selectDiscussPostRows(0));
        System.out.println(user);

    }
}
