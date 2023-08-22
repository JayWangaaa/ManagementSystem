package com.hqu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hqu.mapper.MessageMapper;
import com.hqu.pojo.Message;
import com.hqu.pojo.PageBean;
import com.hqu.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name) {
        PageHelper.startPage(page,pageSize);
        List<Message> messageList = messageMapper.list(name);
        Page<Message> p = (Page<Message>) messageList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(Integer id) {
        messageMapper.delete(id);
    }

    @Override
    public void insert(Message message) {
        message.setCreateTime(LocalDateTime.now());
        message.setUpdateTime(LocalDateTime.now());
        messageMapper.insert(message);
    }

    @Override
    public Message getById(Integer id) {
        return messageMapper.getById(id);
    }

    @Override
    public void update(Message message) {
        message.setUpdateTime(LocalDateTime.now());
        messageMapper.update(message);
    }
}
