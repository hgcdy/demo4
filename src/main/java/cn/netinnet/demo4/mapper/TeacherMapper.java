package cn.netinnet.demo4.mapper;

import cn.netinnet.demo4.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface TeacherMapper {
    public List<TeacherEntity> getTeacherAll();
}
