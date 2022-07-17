package cn.netinnet.demo4.entity;

import java.util.Date;

public class ArrangeTeacherEntity extends Base{
    private Integer courseId;
    private Integer houseId;
    private String week;
    private String timeCode;

    public ArrangeTeacherEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, Integer courseId, Integer houseId, String week, String timeCode) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.courseId = courseId;
        this.houseId = houseId;
        this.week = week;
        this.timeCode = timeCode;
    }

    public ArrangeTeacherEntity() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(String timeCode) {
        this.timeCode = timeCode;
    }
}

