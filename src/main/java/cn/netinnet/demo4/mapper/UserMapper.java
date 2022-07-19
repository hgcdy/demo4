package cn.netinnet.demo4.mapper;

import cn.netinnet.demo4.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //根据账号密码返回记录
    public UserEntity getUser(String userCode, String userPassword);
}
