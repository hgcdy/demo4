package cn.netinnet.demo4.controller;


import cn.netinnet.demo4.constant.impl.ResultStatus;
import cn.netinnet.demo4.entity.TeacherEntity;
import cn.netinnet.demo4.model.ResultModel;
import cn.netinnet.demo4.sevice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

//    //返回教师集合
//    @GetMapping("")
//    public ModelAndView gotoTeacher() {
//        List<TeacherEntity> teacherList = teacherService.getTeacherAll();
//        ModelAndView modelAndView = new ModelAndView("/teacher");
//        modelAndView.addObject("teacherList", teacherList);
//        return modelAndView;
//    }

    //返回教师集合(分页)
    @GetMapping("")
    public ModelAndView gotoTeacher(Integer count) {
        if (count == null)
            count = 1;
        List<TeacherEntity> teacherList = teacherService.getTeacher(count);
        ModelAndView modelAndView = new ModelAndView("/teacher");
        modelAndView.addObject("count", count);
        modelAndView.addObject("teacherList", teacherList);
        return modelAndView;
    }

    //获取单条记录
    @PostMapping("select")
    public ResultModel teacherSelect(Integer id) {
        TeacherEntity teacher = teacherService.getTeacherId(id);
        if (teacher == null) {
            return ResultModel.error(ResultStatus.SELECT_ERROR);
        }
        return ResultModel.ok(teacher);
    }

    //删除
    @PostMapping("delete")
    public ResultModel teacherDelete(Integer id) {
        int i = teacherService.deleteTeacher(id);
        if (i > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.DELETE_ERROR);
    }

    //修改
    @PostMapping("update")
    public ResultModel teacherUpdate(TeacherEntity teacherEntity) {
        int i = teacherService.updateTeacher(teacherEntity);
        if (i > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.UPDATE_ERROR);
    }

    //插入
    @PostMapping("insert")
    public ResultModel teacherInsert(TeacherEntity teacherEntity) {
        int i = teacherService.insertTeacher(teacherEntity);
        if (i > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.INSERT_ERROR);
    }

    //查询总数
    @PostMapping("sum")
    public Integer getSum() {
        return teacherService.getSum();
    }

}
