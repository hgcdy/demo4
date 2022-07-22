package cn.netinnet.demo4.sevice;

import cn.netinnet.demo4.entity.ArrangeStudentEntity;
import cn.netinnet.demo4.model.ResultModel;

import java.util.List;

public interface ArrangeStudentService {

    //查看全部
    public List<ArrangeStudentEntity> getArrangeStudentAll();

    //插入
    public Integer inArrangeStudent(ArrangeStudentEntity ase);
}
