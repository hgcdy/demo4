package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.ArrangeStudentEntity;
import cn.netinnet.demo4.sevice.ArrangeStudentService;

import java.util.List;

public class ArrangeStudentServiceImpl implements ArrangeStudentService {

    @Override
    public List<ArrangeStudentEntity> ArrangeStudent() {
        //时间相同，若是必修，同班课程一样
        //选修，可以不一样
        //如果教室位置够多，可以多个班级在一起上课
        //

        return null;
    }
}
