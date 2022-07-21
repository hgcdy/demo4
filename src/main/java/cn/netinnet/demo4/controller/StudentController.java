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

//    //根据班级id切换
//    @GetMapping("")
//    public ModelAndView getStudentClassId(Integer classId) {
//        ModelAndView modelAndView = new ModelAndView("/student");
//        List<ClassEntity> classList = classService.getClassAll();
//        List<StudentEntity> studentList;
//        if (classId == null){
//            studentList = studentService.getStudentAll();
//        }else{
//            studentList = studentService.getStudentClassId(classId);
//        }
//        modelAndView.addObject("studentList", studentList);
//        modelAndView.addObject("classList", classList);
//        return modelAndView;
//    }

    //根据班级id切换
    @GetMapping("")
    public ModelAndView getStudentClassId(Integer classId, Integer count) {
        ModelAndView modelAndView = new ModelAndView("/student");
        List<ClassEntity> classList = classService.getClassAll();
        List<StudentEntity> studentList;
        if (count == null){
            count = 1;
        }
        if (classId == null){
//            studentList = studentService.getStudentAll();
            studentList = studentService.getStudentPaging(count);
        }else{
//            studentList = studentService.getStudentClassId(classId);
            studentList = studentService.getStudentPagingClassId(classId, count);
        }
        modelAndView.addObject("classId", classId);
        modelAndView.addObject("count", count);
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("classList", classList);
        return modelAndView;
    }

    //删除
    @PostMapping("delete")
    public ResultModel studentDelete(Integer id) {
        int i = studentService.delStudentId(id);
        if (i > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.DELETE_ERROR);
    }

    //修改
    @PostMapping("update")
    public ResultModel studentUpdate(StudentEntity studentEntity) {
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
    public ResultModel studentSelect(Integer id) {
        StudentEntity student = studentService.getStudentId(id);
        if (student == null) {
            return ResultModel.error(ResultStatus.SELECT_ERROR);
        }
        return ResultModel.ok(student);
    }

    //插入单条记录
    @PostMapping("insert")
    public ResultModel studentInsert(StudentEntity studentEntity) {
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

    //检索查询
    @PostMapping("search")
    public List<StudentEntity> studentSearch(StudentEntity studentEntity){
        List<StudentEntity> studentList = studentService.getStudentSearch(studentEntity);
        return studentList;
    }

    //分页查询
    @PostMapping("paging")
    public List<StudentEntity> studentPaging(Integer count){
        return studentService.getStudentPaging(count);
    }

    //查询总数
    @PostMapping("sum")
    public Integer getSum(Integer classId){
        return studentService.getSum(classId);
    }

}
