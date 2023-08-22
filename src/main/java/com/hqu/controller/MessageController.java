package com.hqu.controller;

import com.hqu.pojo.Message;
import com.hqu.pojo.PageBean;
import com.hqu.pojo.Result;
import com.hqu.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/messages")
//@CrossOrigin
public class MessageController {
    @Autowired
    private MessageService messageService;


    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name){
        log.info("分页查询，参数：{}，{},{}",page,pageSize,name);
        PageBean pageBean = messageService.page(page,pageSize,name);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除资讯，参数：{}",id);
        messageService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Message message){
        log.info("新增资讯：{}",message);
        messageService.insert(message);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID获取资讯数据:{}",id);
        Message message =messageService.getById(id);
        return Result.success(message);
    }

    @PutMapping
    public Result update(@RequestBody Message message){
        log.info("更新资讯信息：{}",message);
        messageService.update(message);
        return Result.success();
    }

}
