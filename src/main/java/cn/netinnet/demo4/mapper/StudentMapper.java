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

    //查询指定id的学生
    public StudentEntity getStudentId(Integer id);

    //删除指定id的学生
    public int delStudentId(Integer id);

    //修改指定学生信息
    public int updateStudent(StudentEntity studentEntity);

    //插入记录
    public int insertStudent(StudentEntity studentEntity);

    //检索查询
    public List<StudentEntity> getStudentSearch(StudentEntity studentEntity);

    public List<StudentEntity> getStudentPaging(Integer count);

}
