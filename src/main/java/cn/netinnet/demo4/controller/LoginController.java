package cn.netinnet.demo4.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping("/login")
public class LoginController extends HttpServlet {

    //跳转至login页面
    @GetMapping("")
    public ModelAndView gotoLogin() {
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
}
