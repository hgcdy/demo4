package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.constant.impl.ResultStatus;
import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.entity.StudentEntity;
import cn.netinnet.demo4.entity.TeacherEntity;
import cn.netinnet.demo4.model.ResultModel;
import cn.netinnet.demo4.sevice.ClassService;
import cn.netinnet.demo4.sevice.StudentService;
import cn.netinnet.demo4.sevice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/index")
public class indexController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;
    @Autowired
    private TeacherService teacherService;

    //跳转至index页面
    @GetMapping("")
    public ModelAndView gotoindex() {
        ModelAndView modelAndView = new ModelAndView("/index");
//        List<StudentEntity> studentList = studentService.getStudentAll();
//        List<ClassEntity> classList = classService.getClassAll();
//        modelAndView.addObject("studentList", studentList);
//        modelAndView.addObject("classList", classList);
        return modelAndView;
    }









    //返回教师集合
    @GetMapping("teacher")
    public List<TeacherEntity> indexTeacher() {
        List<TeacherEntity> teacherAll = teacherService.getTeacherAll();
        return teacherAll;
    }


}
