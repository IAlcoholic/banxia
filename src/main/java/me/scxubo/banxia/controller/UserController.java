package me.scxubo.banxia.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import me.scxubo.banxia.domain.Result;
import me.scxubo.banxia.domain.user;
import me.scxubo.banxia.service.UserService;
import me.scxubo.banxia.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @RequestMapping(value="/login")
    public Result login(@PathVariable Integer uid){
        PageHelper.startPage(1,2);
        return ResultUtils.login(null,"亲！要登录额");
    }

    @RequestMapping(value="/{uid}",method= RequestMethod.GET)
    public Result finduid(@PathVariable Integer uid){
        PageHelper.startPage(1,2);
        return ResultUtils.success(UserService.findByid(uid));
    }

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public Result findall(){
        Pageable pageable = new PageRequest(1, 2);
        return ResultUtils.success(UserService.findAll());
    }


}
