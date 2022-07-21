package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.entity.HouseEntity;
import cn.netinnet.demo4.sevice.ClassService;
import cn.netinnet.demo4.sevice.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    //跳转至house页面
    @GetMapping("")
    public ModelAndView gotoHouse() {
        ModelAndView modelAndView = new ModelAndView("/house");
        List<HouseEntity> houseList = houseService.getHouseAll();
        modelAndView.addObject("houseList", houseList);
        return modelAndView;
    }
}
