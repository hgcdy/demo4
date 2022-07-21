package cn.netinnet.demo4.entity;

import java.util.Date;

public class ClassEntity extends Base{
    private String className;
    private Integer num;

    public ClassEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String className, Integer num) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.className = className;
        this.num = num;
    }

    public ClassEntity() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String groupName) {
        this.className = groupName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
