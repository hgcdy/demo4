package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.TeacherEntity;
import cn.netinnet.demo4.mapper.TeacherMapper;
import cn.netinnet.demo4.sevice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    //分页查询
    @Override
    public List<TeacherEntity> getTeacher(Integer count) {
        return teacherMapper.getTeacher(((count - 1) * 3));
    }

    //获取所有老师
    @Override
    public List<TeacherEntity> getTeacherAll() {
        List<TeacherEntity> teacherList = teacherMapper.getTeacherAll();
        return teacherList;
    }

    //插入
    @Override
    public int insertTeacher(TeacherEntity teacherEntity) {
        if (repetition(teacherEntity)) {
            Date date = new Date();
            teacherEntity.setModifyUserId(teacherEntity.getCreateUserId());
            teacherEntity.setModifyTime(date);
            teacherEntity.setCreateTime(date);
            teacherEntity.setDelFlag("0");
            return teacherMapper.insertTeacher(teacherEntity);
        } else {
            return 0;
        }
    }

    //修改
    @Override
    public int updateTeacher(TeacherEntity teacherEntity) {
        Date date = new Date();
        teacherEntity.setModifyTime(date);
        return teacherMapper.updateTeacher(teacherEntity);
    }

    //删除
    @Override
    public int deleteTeacher(Integer id) {
        return teacherMapper.deleteTeacher(id);
    }

    //查询单条
    @Override
    public TeacherEntity getTeacherId(Integer id) {
        return teacherMapper.getTeacherId(id);
    }

    //查询条数
    @Override
    public Integer getSum() {
        return teacherMapper.getSum();
    }

    //密码验证
    @Override
    public TeacherEntity verify(String teacherCode, String teacherPassword) {
        return teacherMapper.verify(teacherCode, teacherPassword);
    }


    //查询是否有名字重复,有重复返回false
    public Boolean repetition(TeacherEntity teacherEntity) {
        List<TeacherEntity> teacherAll = teacherMapper.getTeacherAll();
        for (TeacherEntity t :
                teacherAll) {
            if (teacherEntity.getTeacherName().equals(t.getTeacherName())) {
                return false;
            }
        }
        return true;
    }
}
