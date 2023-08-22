package com.hqu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hqu.mapper.UserMapper;
import com.hqu.pojo.PageBean;
import com.hqu.pojo.User;
import com.hqu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.getByUsernamePassword(user);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name,String username) {
        PageHelper.startPage(page,pageSize);
        List<User> empList = userMapper.list(name,username);
        Page<User> p = (Page<User>) empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public User getById(Integer id) {
        User user = userMapper.getById(id);
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
