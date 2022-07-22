package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.ArrangeTeacherEntity;
import cn.netinnet.demo4.sevice.ArrangeTeacherService;
import org.springframework.stereotype.Service;

@Service
public class ArrangeTeacherServiceImpl implements ArrangeTeacherService {

    @Override
    public Integer inArrangeTeacher(ArrangeTeacherEntity ate) {
        //分别获取教师课程班级查看是否存在
        //查看同一时间内是否教师课程班级是否唯一
        return null;
    }

}
