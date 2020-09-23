package com.hongm.serviceimpl;

import com.hongm.pojo.User;
import com.hongm.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    List<User> list = new ArrayList<>();

    {
        User user1 = new User("1", "张三", "zhangsan", 1, "15055555555", "北京市", "1", "123abc", 12);
        User user2 = new User("2", "李四", "zhangsan", 1, "15055555555", "北京市", "1", "123abc", 12);
        User user3 = new User("3", "王五", "zhangsan", 1, "15055555555", "北京市", "1", "123abc", 12);
        User user4 = new User("3", "王五", "zhangsan", 0, "15055555555", "北京市", "1", "123abc", 12);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
    }

    public List<User> getUsers() {
        return list;
    }


    public boolean isUserExists(String name, String password) {
        for (User user : list) {
            if (user.getLoginName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
