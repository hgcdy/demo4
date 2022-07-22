package cn.netinnet.demo4.mapper;

import cn.netinnet.demo4.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
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

    //分页查询
    public List<TeacherEntity> getTeacher(Integer count);

    //密码验证
    public TeacherEntity verify(String teacherCode, String teacherPassword);
}
