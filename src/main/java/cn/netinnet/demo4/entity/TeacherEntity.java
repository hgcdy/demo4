package cn.netinnet.demo4.entity;

import java.util.Date;

public class TeacherEntity extends Base{
    private String teacherName;
    private String teacherCode;
    private String teacherPassword;

    public TeacherEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String teacherName, String teacherCode, String teacherPassword) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.teacherName = teacherName;
        this.teacherCode = teacherCode;
        this.teacherPassword = teacherPassword;
    }

    public TeacherEntity() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
