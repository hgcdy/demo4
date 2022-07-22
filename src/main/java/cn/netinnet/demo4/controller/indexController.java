package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.sevice.ClassService;
import cn.netinnet.demo4.sevice.StudentService;
import cn.netinnet.demo4.sevice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class indexController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;
    @Autowired
    private TeacherService teacherService;

    //跳转至index页面
    @GetMapping("index")
    public ModelAndView gotoIndex() {
        ModelAndView modelAndView = new ModelAndView("/index");
//        ModelAndView modelAndView = new ModelAndView("/text");
        return modelAndView;
    }

    //跳转至index页面
    @GetMapping("text")
    public ModelAndView gotoText() {
        ModelAndView modelAndView = new ModelAndView("/text");
        return modelAndView;
    }

}
