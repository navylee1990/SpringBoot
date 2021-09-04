package com.lee.community.service;

import com.lee.community.dao.DiscussPostMapper;
import com.lee.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int id,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(id,offset,limit);
    };
    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
