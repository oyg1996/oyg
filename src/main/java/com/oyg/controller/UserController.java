package com.oyg.controller;

import com.oyg.entity.User;
import com.oyg.redis.RedisCacheManager;
import com.oyg.service.UserService;
import com.oyg.utils.ProtoStuffSerializerUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * Created by Administrator on 2017/12/19.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @RequestMapping(value ="/insert")
    public @ResponseBody Object insert(User user){
        user = userService.insert(user);
        return user;
    }

    @RequestMapping(value ="/test")
    public @ResponseBody Object test(){
        User user = new User(1, "11", "111");
        byte[] serialize = ProtoStuffSerializerUtils.serialize(user);
        boolean user1 = redisCacheManager.set("user",serialize,3600 );
        return user1;
    }
    @RequestMapping(value ="/key")
    public @ResponseBody Object key(){
        User user = new User(1, "11", "111");
        boolean user1 = redisCacheManager.set("user",user,3600 );
        return user1;
    }
    @RequestMapping(value ="/value")
    public @ResponseBody Object value(){
        User user = (User) redisCacheManager.get("user");
        return user;
    }
    @RequestMapping(value ="/testList")
    public @ResponseBody Object testList(){
        User user = new User(1, "11", "111");
        User user1 = new User(1, "11", "111");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);users.add(user1);
//        byte[] bytes = ProtoStuffSerializerUtils.serializeList(users);
        boolean b = redisCacheManager.set("user", users, 3600);
        return b;
    }
    @RequestMapping(value ="/test11")
    public @ResponseBody Object test11(){
        Object user1 = redisCacheManager.get("user");
        User user = ProtoStuffSerializerUtils.deserialize((byte[]) user1, User.class);
//        System.out.println(user1);
        return user;
    }
    @RequestMapping(value ="/testList11")
    public @ResponseBody Object testList11(){
        List<User> users =(List<User>) redisCacheManager.get("user");
//        List<User> users = ProtoStuffSerializerUtils.deserializeList((byte[]) user1, User.class);
//        System.out.println(user1);
        return users;
    }
    @RequestMapping(value ="/del")
    public @ResponseBody Object del(){
        redisCacheManager.del("pcHomeBanner");
        return true;
    }

    @RequestMapping(value ="/rrr")
    public @ResponseBody Object rrr(){
        redisCacheManager.del("pcHomeBanner");
        return true;
    }


}
