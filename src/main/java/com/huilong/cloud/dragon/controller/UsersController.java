package com.huilong.cloud.dragon.controller;

import com.huilong.cloud.dragon.model.UsersPO;
import com.huilong.cloud.dragon.proxy.DragonInvocationHandler;
import com.huilong.cloud.dragon.service.UsersService;
import com.huilong.cloud.dragon.service.impl.UserServiceNoDaoImpl;
import com.huilong.cloud.dragon.util.ResponseUtil;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.RandomAccess;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghuilong
 * @desc
 * @since 2018/11/11
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody UsersPO usersPO){
        if (usersPO !=null && usersPO.getPhoneNo() !=null && usersPO.getLoginPwd() !=null){
            UsersPO data = usersService.login(usersPO.getPhoneNo(), usersPO.getLoginPwd());

            return ResponseUtil.success(data);
        }

        return ResponseUtil.error();

    }

    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    public String get(@RequestBody Map<String,String> map){

        String name = map.get("name");
        List<UsersPO> userlist = usersService.listByName(name);

        return ResponseUtil.success(userlist);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody UsersPO usersPO){

        int i = new Random().nextInt();
        usersPO.setLoginId(String.valueOf(i));
        usersPO.setUserCreated(110L);
        usersPO.setUserModified(110L);
        usersPO.setIsBlock(0);
        usersPO.setIsDeleted(0);
        Boolean result = usersService.add(usersPO);

        return ResponseUtil.success(result);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody UsersPO usersPO){

        usersPO.setUserCreated(110L);
        usersPO.setUserModified(110L);
        usersPO.setIsBlock(0);
        usersPO.setIsDeleted(0);
        Boolean result = usersService.update(usersPO);

        return ResponseUtil.success(result);
    }




    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Integer id){


        Boolean result = usersService.delete(id);

        return ResponseUtil.success(result);
    }




}
