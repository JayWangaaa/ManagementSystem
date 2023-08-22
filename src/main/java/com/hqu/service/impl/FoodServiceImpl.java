package com.hqu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hqu.mapper.FoodMapper;
import com.hqu.pojo.Food;
import com.hqu.pojo.Message;
import com.hqu.pojo.PageBean;
import com.hqu.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, String location, String score) {
        PageHelper.startPage(page,pageSize);
        List<Food> foodList = foodMapper.list(name,location,score);
        Page<Food> p = (Page<Food>) foodList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(Integer id) {
        foodMapper.delete(id);
    }

    @Override
    public void insert(Food food) {
        foodMapper.insert(food);
    }

    @Override
    public Food getById(Integer id) {
        return foodMapper.getById(id);
    }

    @Override
    public void update(Food food) {
        foodMapper.update(food);
    }
}
