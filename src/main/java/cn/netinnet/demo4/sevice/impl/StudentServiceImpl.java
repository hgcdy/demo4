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

    @Override
    public StudentEntity getStudentId(Integer id) {
        return studentMapper.getStudentId(id);
    }

    @Override
    public int delStudentId(Integer id) {
        return studentMapper.delStudentId(id);
    }

    @Override
    public int updateStudent(StudentEntity studentEntity) {
        return studentMapper.updateStudent(studentEntity);
    }

    @Override
    public int insertStudent(StudentEntity studentEntity) {
        //插入时判断是否相同
        List<StudentEntity> studentAll = studentMapper.getStudentAll();
        for (StudentEntity s:
             studentAll) {
            if (studentEntity.getStudentName().equals(s.getStudentName())){
                return 0;
            }
        }
        return studentMapper.insertStudent(studentEntity);
    }

    //检索查询
    @Override
    public List<StudentEntity> getStudentSearch(StudentEntity studentEntity){
        List<StudentEntity> studentList = studentMapper.getStudentSearch(studentEntity);
        return studentList;
    }

    //分页查询
    @Override
    public List<StudentEntity> getStudentPaging(Integer count) {
        return studentMapper.getStudentPaging(((count - 1) * 10));
    }
}
