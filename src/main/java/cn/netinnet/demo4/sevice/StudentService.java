package cn.netinnet.demo4.sevice;



import cn.netinnet.demo4.entity.StudentEntity;

import java.util.List;

public interface StudentService {

//    根据班级id获取该班级的所有学生
    public List<StudentEntity> getStudentClassId(Integer classId);

    //查询所有
    public List<StudentEntity> getStudentAll();

    //查询指定id的学生
    public StudentEntity getStudentId(Integer id);

    //删除指定id的记录
    public int delStudentId(Integer id);

    //修改指定学生信息
    public int updateStudent(StudentEntity studentEntity);

    //插入数据
    public int insertStudent(StudentEntity studentEntity);

    //检索查询
    public List<StudentEntity> getStudentSearch(StudentEntity studentEntity);

    public List<StudentEntity> getStudentPaging(Integer count);

}
