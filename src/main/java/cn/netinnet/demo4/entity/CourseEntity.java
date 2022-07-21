package cn.netinnet.demo4.entity;

import java.util.Date;

public class CourseEntity extends Base{
    private String courseName;
    private String houseType;
    //必修课程
    private String RequiredCourse;

    public CourseEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String courseName, String houseType, String requiredCourse) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.courseName = courseName;
        this.houseType = houseType;
        RequiredCourse = requiredCourse;
    }

    public CourseEntity() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getRequiredCourse() {
        return RequiredCourse;
    }

    public void setRequiredCourse(String requiredCourse) {
        RequiredCourse = requiredCourse;
    }
}
