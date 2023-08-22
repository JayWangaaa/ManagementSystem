package com.hqu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hqu.mapper.AttractionMapper;
import com.hqu.pojo.Attraction;
import com.hqu.pojo.PageBean;
import com.hqu.service.AttractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AttractionServiceImpl implements AttractionService {
    @Autowired
    private AttractionMapper attractionMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, String location, String score) {
        PageHelper.startPage(page,pageSize);
        List<Attraction> attractionList = attractionMapper.list(name,location,score);
        Page<Attraction> p = (Page<Attraction>) attractionList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(Integer id) {
        attractionMapper.delete(id);
    }

    @Override
    public void insert(Attraction attraction) {
        attractionMapper.insert(attraction);
    }

    @Override
    public Attraction getById(Integer id) {
        return attractionMapper.getByID(id);
    }

    @Override
    public void update(Attraction attraction) {
        attractionMapper.update(attraction);
    }
}
