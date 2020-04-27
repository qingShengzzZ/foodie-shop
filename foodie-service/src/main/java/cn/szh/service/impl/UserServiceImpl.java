package cn.szh.service.impl;

import cn.szh.mapper.UsersMapper;
import cn.szh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    public UsersMapper userMapper;
    @Override
    public boolean queryUsernameIsExist(String username) {
        return false;
    }
}
