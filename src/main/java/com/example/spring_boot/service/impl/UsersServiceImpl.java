package com.example.spring_boot.service.impl;

import com.example.spring_boot.bean.Users;
import com.example.spring_boot.mapper.UsersMapper;
import com.example.spring_boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Administrator
 * @Date: Created in 15:39 2019/1/2
 * @ClassName UsersServiceImpl
 **/
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users login(Users users) {
        return usersMapper.login(users);
    }

    @CacheEvict( value = "userList" ,allEntries = true)
    @Override
    public boolean sendUsers(Users users) {
        return usersMapper.sendUsers(users);
    }

    @Override
    public Users selectsolo(String username) {
        return usersMapper.selectsolo(username);
    }

    @CacheEvict( value = "userList" ,allEntries = true)
    @Override
    public boolean del(Integer id) {
        return usersMapper.del(id);
    }

    @Cacheable (value="userList" )
    @Override
    public List<Users> All() {
        System.out.println("All，输出此句代表没有走缓存");

        return usersMapper.All();
    }
}
