package cn.netinnet.demo4.entity;

import java.util.Date;

public class UserEntity extends Base{
    private String userName;
    private String userCode;
    private String userPassword;

    public UserEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String userName, String userCode, String userPassword) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.userName = userName;
        this.userCode = userCode;
        this.userPassword = userPassword;
    }

    public UserEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
