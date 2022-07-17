package cn.netinnet.demo4.entity;

import java.util.Date;

//学生，教师，课程关联
public class StudentTeacherCourseEntity extends Base{
    private Integer studentId;
    private Integer teacherId;
    private Integer courseId;
    private String required;

    public StudentTeacherCourseEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, Integer studentId, Integer teacherId, Integer courseId, String required) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.required = required;
    }

    public StudentTeacherCourseEntity() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }
}
