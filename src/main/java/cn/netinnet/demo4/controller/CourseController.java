package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.entity.CourseEntity;
import cn.netinnet.demo4.entity.HouseEntity;
import cn.netinnet.demo4.sevice.CourseService;
import cn.netinnet.demo4.sevice.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //跳转至house页面
    @GetMapping("")
    public ModelAndView gotoCourse() {
        ModelAndView modelAndView = new ModelAndView("/course");
        List<CourseEntity> courseList = courseService.getCourseAll();
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }
}
