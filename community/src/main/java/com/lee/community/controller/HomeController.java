package com.lee.community.controller;

import com.lee.community.dao.UserMapper;
import com.lee.community.entity.DiscussPost;
import com.lee.community.entity.Page;
import com.lee.community.entity.User;
import com.lee.community.service.DiscussPostService;
import com.lee.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {    @Autowired
private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        page.setPath("/index");
        page.setRows(discussPostService.findDiscussPostRows(0));
        List<DiscussPost> lists =new ArrayList<DiscussPost>();
        List<Map<String,Object>> discussPost=new ArrayList<Map<String,Object>>();
        lists=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        for(DiscussPost post : lists){
            Map<String,Object>map=new HashMap<>();
            map.put("post",post);
            User user=userService.findUserById(post.getUserId());
            map.put("user",user);
            discussPost.add(map);
        }
        model.addAttribute("discussPost",discussPost);
        model.addAttribute("page",page);
        return "index";
    }



}
