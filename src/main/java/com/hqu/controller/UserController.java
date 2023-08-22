package com.hqu.controller;

import com.hqu.pojo.PageBean;
import com.hqu.pojo.R;
import com.hqu.pojo.Result;
import com.hqu.pojo.User;
import com.hqu.service.UserService;
import com.hqu.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public R login(@RequestBody User user){
        try{
            User currentUser = userService.login(user);
            if(currentUser !=null){
                Map map = new HashMap(16);
                map.put("token",JwtUtils.getJwtToken(String.valueOf(currentUser.getId()),
                        currentUser.getUsername()));
                return R.ok().data(map);
            }else{
                return R.error();
            }
        }catch (Exception e){
            return R.error();
        }
    }

    @GetMapping("info")
    public R info(HttpServletRequest request){
        String memberIdByJwtToken = JwtUtils.getMemberIdByJwtToken(request);
        User user = userService.getById(Integer.valueOf(memberIdByJwtToken));
        Map map = new HashMap<>();
        map.put("name",user.getUsername());
        map.put("avatar",user.getImage());
        return R.ok().data(map);
    }


    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,String username){
        log.info("分页查询，参数：{}，{},{},{}",page,pageSize,name,username);
        PageBean pageBean = userService.page(page,pageSize,name,username);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除员工，参数：{}",id);
        userService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody User user){
        log.info("新增员工：{}",user);
        userService.insert(user);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID获取员工数据:{}",id);
        User user =userService.getById(id);
        return Result.success(user);
    }

    @PutMapping
    public Result update(@RequestBody User user){
        log.info("更新员工信息：{}",user);
        userService.update(user);
        return Result.success();
    }

}
