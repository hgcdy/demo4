package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.StudentEntity;
import cn.netinnet.demo4.mapper.StudentMapper;
import cn.netinnet.demo4.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

//    根据班级id获取该班级的所有学生
    @Override
    public List<StudentEntity> getStudentClassId(Integer classId) {
        return studentMapper.getStudentClassId(classId);
    }

    //查询所有
    @Override
    public List<StudentEntity> getStudentAll() {
        return studentMapper.getStudentAll();
    }

}
