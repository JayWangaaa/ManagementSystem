package com.hqu.controller;

import com.hqu.pojo.Food;
import com.hqu.pojo.PageBean;
import com.hqu.pojo.Result;
import com.hqu.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/foods")
//@CrossOrigin
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,String location,String score){
        log.info("分页查询，参数：{}，{},{}",page,pageSize,name,location,score);
        PageBean pageBean = foodService.page(page,pageSize,name,location,score);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除美食，参数：{}",id);
        foodService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Food food){
        log.info("新增美食：{}",food);
        foodService.insert(food);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID获取资讯数据:{}",id);
        Food food =foodService.getById(id);
        return Result.success(food);
    }

    @PutMapping
    public Result update(@RequestBody Food food){
        log.info("更新资讯信息：{}",food);
        foodService.update(food);
        return Result.success();
    }
}
