package cn.szh.service;

import cn.szh.pojo.Users;
import cn.szh.pojo.bo.UserBO;

public interface UserService {

    /**
     * @param username
     * @return
     */
    boolean queryUsernameIsExist(String username);
    /**
     * 创建用户
     * @param userBO
     * @return
     */
    Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    Users queryUserForLogin(String username, String password);



}
