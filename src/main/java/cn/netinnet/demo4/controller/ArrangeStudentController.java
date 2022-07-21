package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.sevice.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/arrangeStudent")
public class ArrangeStudentController {

    //跳转至arrangeStudent页面
    @GetMapping("")
    public ModelAndView gotoClass() {
        ModelAndView modelAndView = new ModelAndView("/arrangeStudent");
        return modelAndView;
    }



}
