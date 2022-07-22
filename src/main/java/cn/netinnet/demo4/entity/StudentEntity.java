package cn.netinnet.demo4.entity;

import java.util.Date;

public class StudentEntity extends Base {
    private String studentName;
    private String sex;
    private Integer age;
    private Integer classId;

    public StudentEntity(Integer id, String delFlag, Date createTime, Integer createUserId, Date modifyTime, Integer modifyUserId, String studentName, String sex, Integer age, Integer classId) {
        super(id, delFlag, createTime, createUserId, modifyTime, modifyUserId);
        this.studentName = studentName;
        this.sex = sex;
        this.age = age;
        this.classId = classId;
    }

    public StudentEntity() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
