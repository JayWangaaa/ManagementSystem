package com.hqu.controller;

import com.hqu.pojo.Attraction;
import com.hqu.pojo.PageBean;
import com.hqu.pojo.Result;
import com.hqu.service.AttractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/attractions")
//@CrossOrigin
public class AttractionController {
    @Autowired
    private AttractionService attractionService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, String location, String score){
        log.info("分页查询，参数哈哈哈哈：{}，{},{}",page,pageSize,name,location,score);
        PageBean pageBean = attractionService.page(page,pageSize,name,location,score);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除景区哈，参数：{}",id);
        System.out.println("斤斤计较");
        System.out.println("adsadadadsd");
        attractionService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Attraction attraction){
        log.info("新增景区：{}",attraction);
        attractionService.insert(attraction);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID获取资讯数据:{}",id);
        Attraction attraction =attractionService.getById(id);
        return Result.success(attraction);
    }

    @PutMapping
    public Result update(@RequestBody Attraction attraction){
        log.info("更新资讯信息：{}",attraction);
        attractionService.update(attraction);
        return Result.success();
    }
}
