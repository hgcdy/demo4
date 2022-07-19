package cn.netinnet.demo4.controller;


import cn.netinnet.demo4.constant.impl.ResultStatus;
import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.entity.StudentEntity;
import cn.netinnet.demo4.model.ResultModel;
import cn.netinnet.demo4.sevice.ClassService;
import cn.netinnet.demo4.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    //根据班级id切换
    @GetMapping("")
    public ModelAndView getStudentClassId(Integer classId) {
        ModelAndView modelAndView = new ModelAndView("/student");
        List<ClassEntity> classList = classService.getClassAll();
        List<StudentEntity> studentList;
        if (classId == null){
            studentList = studentService.getStudentAll();
        }else{
            studentList = studentService.getStudentClassId(classId);
        }
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("classList", classList);
        return modelAndView;
    }

    //删除
    @PostMapping("delete")
    public ResultModel indexDelete(Integer id) {
        int i = studentService.delStudentId(id);
        if (i > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.DELETE_ERROR);
    }

    //修改
    @PostMapping("update")
    public ResultModel indexUpdate(StudentEntity studentEntity) {
        Date date = new Date();
        studentEntity.setModifyTime(date);
        int i = studentService.updateStudent(studentEntity);
        if (i > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.DELETE_ERROR);
    }

    //查询单条记录
    @PostMapping("select")
    public ResultModel indexSelect(Integer id) {
        StudentEntity student = studentService.getStudentId(id);
        if (student == null) {
            return ResultModel.error(ResultStatus.SELECT_ERROR);
        }
        return ResultModel.ok(student);
    }

    //插入单条记录
    @PostMapping("insert")
    public ResultModel indexInsert(StudentEntity studentEntity) {
        Date date = new Date();
        studentEntity.setModifyUserId(studentEntity.getCreateUserId());
        studentEntity.setModifyTime(date);
        studentEntity.setCreateTime(date);
        studentEntity.setDelFlag("0");
        //若有字段为空，跳出
        try {
            int i = studentService.insertStudent(studentEntity);
            if (i > 0) {
                return ResultModel.ok();
            }
            return ResultModel.error(ResultStatus.INSERT_ERROR);
        } catch (Exception e) {
            return ResultModel.error(ResultStatus.INSERT_ERROR);
        }
    }
}
