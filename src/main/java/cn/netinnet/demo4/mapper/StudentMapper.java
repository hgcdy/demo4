package cn.netinnet.demo4.mapper;

import cn.netinnet.demo4.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

//    根据班级id获取该班级的所有学生
    public List<StudentEntity> getStudentClassId(Integer classId);

    //查询所有学生
    public List<StudentEntity> getStudentAll();

}
