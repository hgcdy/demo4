package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.sevice.ArrangeStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/arrangeStudent")
public class ArrangeStudentController {

    @Autowired
    private ArrangeStudentService arrangeStudentService;

    //跳转至arrangeStudent页面
    @GetMapping("")
    public ModelAndView gotoClass(Integer count) {
        ModelAndView modelAndView = new ModelAndView("/arrangeStudent");
//        List<ArrangeStudentEntity> arrangeStudentList = arrangeStudentService.getArrangeStudentAll(count);
//        modelAndView.addObject("arrangeStudentList", arrangeStudentList);
        modelAndView.addObject("count", count);
        return modelAndView;
    }



}
