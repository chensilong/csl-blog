package com.csl.demo.service;


import com.csl.demo.bean.Users;

import java.util.List;

/**
 * @Author: Administrator
 * @Date: Created in 15:38 2019/1/2
 * @ClassName UsersService
 **/
public interface UsersService {
    public Users login(Users users);
    public boolean sendUsers(Users users);
    public Users selectsolo(String username);
    public boolean del(Integer id);
    public List<Users> All();
}
