package cn.netinnet.demo4.controller;

import cn.netinnet.demo4.constant.impl.ResultStatus;
import cn.netinnet.demo4.entity.StudentEntity;
import cn.netinnet.demo4.entity.UserEntity;
import cn.netinnet.demo4.model.ResultModel;
import cn.netinnet.demo4.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@RestController
@RequestMapping("/login")
public class LoginController extends HttpServlet {

    @Autowired
    private UserService userService;

    //跳转至login页面
    @GetMapping("")
    public ModelAndView gotoLogin() {
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }

    //登录验证
    @PostMapping("verify")
    public ResultModel loginVerify(String userCode, String userPassword) {
        UserEntity user = userService.getUser(userCode, userPassword);
        if (user == null){
            return ResultModel.error(ResultStatus.PARAM_ERROR);
        }
        return ResultModel.ok(user);
    }
}
