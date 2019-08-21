package com.thingingcao.jpa.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thingingcao.jpa.common.ResponseResult;
import com.thingingcao.jpa.entity.Student;
import com.thingingcao.jpa.service.StudentService;
 
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
 
    //添加一个学生
    @PostMapping(value = "/addStudent")
    public ResponseResult addStudent(Student student) {
        ResponseResult result = new ResponseResult();
        try {
            studentService.addStudent(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //修改一个学生(jpa是根据id来修改的)
    @PutMapping(value = "/updateStudent")
    public ResponseResult updateStudentById(Student student) {
        ResponseResult result = new ResponseResult();
        try {
            studentService.updateStudent(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //根据id删除一条数据
    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseResult deleteStudentById(@PathVariable(name = "id", required = true) Long id) {
        ResponseResult result = new ResponseResult();
        try {
            studentService.deleteStudentById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //查询所有
    @GetMapping(value = "/findAll")
    public ResponseResult findAll() {
        ResponseResult result = new ResponseResult();
        try {
            List<Student> list = studentService.findAll();
            //将查询结果封装到CommonResult中
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findStudentById/{id}")
    public ResponseResult findStudentById(@PathVariable(name = "id") Long id) {
        ResponseResult result = new ResponseResult();
        try {
            Student student = studentService.findStudentById(id);
            //将查询结果封装到CommonResult中
            result.setData(student);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //根据学生姓名查询多条数据
    @GetMapping(value = "/findStudentByName")
    public ResponseResult findStudentByName(String name) {
        ResponseResult result = new ResponseResult();
        try {
            List<Student> studentList = studentService.findStudentByName(name);
            //将查询结果封装到CommonResult中
            result.setData(studentList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
}
