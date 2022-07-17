package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.entity.StudentEntity;
import cn.netinnet.demo4.sevice.ClassService;
import cn.netinnet.demo4.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/index")
public class indexController {

    @Autowired
    private StudentService studentSevice;
    @Autowired
    private ClassService classSevice;

    //跳转至index页面
    @GetMapping("")
    public ModelAndView gotoindex() {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<StudentEntity> studentList = studentSevice.getStudentAll();
        List<ClassEntity> classList = classSevice.getClassAll();
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("classList", classList);
        return modelAndView;
    }

//    @PostMapping("")
//    public ModelAndView gotoindex(@RequestParam("userCode") Integer classId) {
//        ModelAndView modelAndView = new ModelAndView("/index");
//        List<StudentEntity> studentList = studentSevice.getStudentClassId(classId);
//        modelAndView.addObject("studentList", studentList);
//        return modelAndView;
//    }

    @PostMapping("")
    public List<StudentEntity> gotoindex(@RequestParam("userCode") Integer classId) {
        List<StudentEntity> studentList = studentSevice.getStudentClassId(classId);
        return studentList;
    }

}
