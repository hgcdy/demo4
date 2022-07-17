package cn.netinnet.demo4.entity;

import java.util.Date;


public class Base {
    private Integer id;
    private String delFlag;
    //创建时间
    private Date createTime;
    //创建人id
    private Integer createUserId;
    //修改时间
    private Date modifyTime;
    //修改人id
    private Integer modifyUserId;

    public Base(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId) {
        this.id = id;
        this.delFlag = delFlag;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.modifyTime = modifyTime;
        this.modifyUserId = modifyUserId;
    }

    public Base() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }
}
