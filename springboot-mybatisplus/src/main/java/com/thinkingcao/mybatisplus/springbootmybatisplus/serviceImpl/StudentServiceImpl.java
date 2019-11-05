package com.thinkingcao.mybatisplus.springbootmybatisplus.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thinkingcao.mybatisplus.springbootmybatisplus.entity.Student;
import com.thinkingcao.mybatisplus.springbootmybatisplus.mapper.StudentMapper;
import com.thinkingcao.mybatisplus.springbootmybatisplus.service.IStudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jack
 * @since 2018-08-04
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}