package cn.netinnet.demo4.entity;

import java.util.Date;

public class ArrangeStudentEntity extends Base{
    private Integer classId;
    private Integer studentId;
    private Integer courseId;
    private String requiredCourse;
    private Integer houseId;
    private String week;
    private String timeCode;

    public ArrangeStudentEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, Integer classId, Integer studentId, Integer courseId, String requiredCourse, Integer houseId, String week, String timeCode) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.classId = classId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.requiredCourse = requiredCourse;
        this.houseId = houseId;
        this.week = week;
        this.timeCode = timeCode;
    }

    public ArrangeStudentEntity() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getRequiredCourse() {
        return requiredCourse;
    }

    public void setRequiredCourse(String requiredCourse) {
        this.requiredCourse = requiredCourse;
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
