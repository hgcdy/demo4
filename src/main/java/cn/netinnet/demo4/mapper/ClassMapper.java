package cn.netinnet.demo4.mapper;

import cn.netinnet.demo4.entity.ClassEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    //查询所有班级
    public List<ClassEntity> getClassAll();

    //查询指定id班级
    public ClassEntity getClassId();
}
