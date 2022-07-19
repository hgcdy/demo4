package cn.netinnet.demo4.sevice;

import cn.netinnet.demo4.entity.UserEntity;

public interface UserService {
    public UserEntity getUser(String userCode, String userPassword);
}
