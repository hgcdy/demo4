package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.ArrangeStudentEntity;
import cn.netinnet.demo4.entity.CourseEntity;
import cn.netinnet.demo4.entity.HouseEntity;
import cn.netinnet.demo4.mapper.*;
import cn.netinnet.demo4.sevice.ArrangeStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrangeStudentServiceImpl implements ArrangeStudentService {

    @Autowired
    private ArrangeStudentMapper arrangeStudentMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<ArrangeStudentEntity> getArrangeStudentAll() {
        return arrangeStudentMapper.getArrangeStudentAll();
    }

    @Override
    public Integer inArrangeStudent(ArrangeStudentEntity ase) {
        //判断是否存在
        //。。。

        //ase课程教室的类型（得到课程教室表进行对比）
        CourseEntity courseId = courseMapper.getCourseId(ase.getCourseId());
        HouseEntity houseId = houseMapper.getHouseId(ase.getHouseId());
        if (!courseId.getHouseType().equals(houseId.getType())) {
            return 0;
        }
//        同一时间，同一教室是否已有安排课程（sql查询教室是否有记录返回）
        ArrangeStudentEntity newase = new ArrangeStudentEntity();
        newase.setWeek(ase.getWeek());
        newase.setTimeCode(ase.getTimeCode());
        newase.setHouseId(ase.getHouseId());
        if (arrangeStudentMapper.getArrangeStudent(newase).size() > 0) {
            return 0;
        }


        //必修是1，选修是0
        if (ase.getRequiredCourse().equals("0")) {

        }


//        if(选修)
//            判断该学生是否已经有选修课冲突（sql，学生id，选修查询是否有记录）
//             判断选修人数与班级座位
//        else
//            判断班级是否已经有冲突（sql，班级id，是否有记录返回
//               该教室是否已经有安排班级（sql，条件教室id，返回班级id并去重）
//                  若为同班，直接插入
//                    若不同 判断人数与座位（）

        return null;
    }
}
