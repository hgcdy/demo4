package cn.netinnet.demo4.mapper;


import cn.netinnet.demo4.entity.CourseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    //查询所有课程
    public List<CourseEntity> getCourseAll();

    //查询指定id课程
    public CourseEntity getCourseId(Integer id);
}
