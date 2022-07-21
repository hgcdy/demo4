package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.CourseEntity;
import cn.netinnet.demo4.entity.HouseEntity;
import cn.netinnet.demo4.mapper.CourseMapper;
import cn.netinnet.demo4.mapper.HouseMapper;
import cn.netinnet.demo4.sevice.CourseService;
import cn.netinnet.demo4.sevice.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseEntity> getCourseAll() {
        return courseMapper.getCourseAll();
    }
}
