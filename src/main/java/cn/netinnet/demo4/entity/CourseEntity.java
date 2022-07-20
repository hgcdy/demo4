package cn.netinnet.demo4.entity;

import java.util.Date;

public class CourseEntity extends Base{
    private String courseName;
    private String house_type;
    //必修课程
    private String RequiredCourse;

    public CourseEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String courseName, String house_type, String requiredCourse) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.courseName = courseName;
        this.house_type = house_type;
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

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getRequiredCourse() {
        return RequiredCourse;
    }

    public void setRequiredCourse(String requiredCourse) {
        RequiredCourse = requiredCourse;
    }
}
