package cn.netinnet.demo4.sevice;

import cn.netinnet.demo4.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {

    //分页查询
    public List<TeacherEntity> getTeacher(Integer count);

    //查询所有
    public List<TeacherEntity> getTeacherAll();

    //插入
    public int insertTeacher(TeacherEntity teacherEntity);

    //修改
    public int updateTeacher(TeacherEntity teacherEntity);

    //删除
    public int deleteTeacher(Integer id);

    //查询单条
    public TeacherEntity getTeacherId(Integer id);

    //查询条数
    public Integer getSum();

    //密码验证
    public TeacherEntity verify(String teacherCode, String teacherPassword);
}
