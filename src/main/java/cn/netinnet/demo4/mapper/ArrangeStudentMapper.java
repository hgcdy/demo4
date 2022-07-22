package cn.netinnet.demo4.mapper;

import cn.netinnet.demo4.entity.ArrangeStudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArrangeStudentMapper {

    //查询所有班级
    public List<ArrangeStudentEntity> getArrangeStudentAll();

    //条件查询
    public List<ArrangeStudentEntity> getArrangeStudent(ArrangeStudentEntity arrangeStudentEntity);
}
