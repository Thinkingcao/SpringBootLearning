package com.thinkingcao.springbootmybatisplus.service.impl;

import com.thinkingcao.springbootmybatisplus.entity.Student;
import com.thinkingcao.springbootmybatisplus.mapper.StudentMapper;
import com.thinkingcao.springbootmybatisplus.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cao_wencao
 * @since 2019-09-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
