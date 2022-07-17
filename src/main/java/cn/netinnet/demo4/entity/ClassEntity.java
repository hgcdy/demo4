package cn.netinnet.demo4.entity;

import java.util.Date;

public class ClassEntity extends Base{
    private String className;
    private Integer count;

    public ClassEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String className, Integer count) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.className = className;
        this.count = count;
    }

    public ClassEntity() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String groupName) {
        this.className = groupName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
