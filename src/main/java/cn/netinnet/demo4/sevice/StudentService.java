package cn.netinnet.demo4.sevice;



import cn.netinnet.demo4.entity.StudentEntity;

import java.util.List;

public interface StudentService {

//    根据班级id获取该班级的所有学生
    public List<StudentEntity> getStudentClassId(Integer classId);

    //查询所有
    public List<StudentEntity> getStudentAll();

}
