package cn.netinnet.demo4.sevice;

import cn.netinnet.demo4.entity.ClassEntity;

import java.util.List;

public interface ClassService {

    //获取所有班级
    public List<ClassEntity> getClassAll();
}
