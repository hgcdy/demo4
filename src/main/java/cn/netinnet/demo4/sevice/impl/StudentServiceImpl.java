package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.StudentEntity;
import cn.netinnet.demo4.mapper.StudentMapper;
import cn.netinnet.demo4.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    //根据id查询
    @Override
    public StudentEntity getStudentId(Integer id) {
        return studentMapper.getStudentId(id);
    }

    //删除指定id
    @Override
    public int delStudentId(Integer id) {
        return studentMapper.delStudentId(id);
    }

    //修改
    @Override
    public int updateStudent(StudentEntity studentEntity) {
        //判断是否有重复
        if (studentMapper.getRepetition(studentEntity) == 0) {
            return studentMapper.updateStudent(studentEntity);
        } else {
            return 0;
        }
    }

    //插入
    @Override
    public int insertStudent(StudentEntity studentEntity) {
        //判断是否有重复
        if (studentMapper.getRepetition(studentEntity) == 0) {
            Date date = new Date();
            studentEntity.setModifyUserId(studentEntity.getCreateUserId());
            studentEntity.setModifyTime(date);
            studentEntity.setCreateTime(date);
            studentEntity.setDelFlag("0");
            return studentMapper.insertStudent(studentEntity);
        } else {
            return 0;
        }
    }

    //检索查询
    @Override
    public List<StudentEntity> getStudentSearch(StudentEntity studentEntity) {
        List<StudentEntity> studentList = studentMapper.getStudentSearch(studentEntity);
        return studentList;
    }

    //分页查询
    @Override
    public List<StudentEntity> getStudentPaging(Integer count) {
        return studentMapper.getStudentPaging(((count - 1) * 3));
    }

    //班级学生分页
    @Override
    public List<StudentEntity> getStudentPagingClassId(Integer classId, Integer count) {
        return studentMapper.getStudentPagingClassId(classId, ((count - 1) * 3));
    }

    //查询总条数
    @Override
    public Integer getSum(Integer classId) {
        return studentMapper.getSum(classId);
    }
}