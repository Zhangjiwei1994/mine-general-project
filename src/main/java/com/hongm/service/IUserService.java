package com.hongm.service;

import com.hongm.pojo.User;

import java.util.List;

public interface IUserService {
    public List<User> getUsers();

    public boolean isUserExists(String name, String password);
}
