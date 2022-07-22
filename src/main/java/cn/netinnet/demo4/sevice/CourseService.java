package cn.netinnet.demo4.sevice;

import cn.netinnet.demo4.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    //获取所有班级
    public List<CourseEntity> getCourseAll();
}
