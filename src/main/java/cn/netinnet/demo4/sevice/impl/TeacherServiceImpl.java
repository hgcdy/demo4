package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.TeacherEntity;
import cn.netinnet.demo4.mapper.TeacherMapper;
import cn.netinnet.demo4.sevice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    //获取所有老师
    @Override
    public List<TeacherEntity> getTeacherAll() {
        List<TeacherEntity> teacherList = teacherMapper.getTeacherAll();
        return teacherList;
    }
}
