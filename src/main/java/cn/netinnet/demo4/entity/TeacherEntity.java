package cn.netinnet.demo4.entity;

import java.util.Date;

public class TeacherEntity extends Base{
    private String teacherName;

    public TeacherEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String teacherName) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.teacherName = teacherName;
    }

    public TeacherEntity() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
