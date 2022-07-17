package cn.netinnet.demo4.entity;

import java.util.Date;

public class HouseEntity extends Base{
    private String houseName;
    private String type;
    private Integer seat;

    public HouseEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String houseName, String type, Integer seat) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.houseName = houseName;
        this.type = type;
        this.seat = seat;
    }

    public HouseEntity() {
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}
