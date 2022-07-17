package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.entity.TeacherEntity;
import cn.netinnet.demo4.sevice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    public TeacherService teacherSevice;

    //跳转至teacher页面
    @GetMapping("")
    public ModelAndView gotoindex() {
        ModelAndView modelAndView = new ModelAndView("/teacher");
        List<TeacherEntity> teacherList = teacherSevice.getTeacherAll();
        modelAndView.addObject("teacherList", teacherList);
        return modelAndView;
    }
}
