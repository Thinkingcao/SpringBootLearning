package com.thinkingcao.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thinkingcao.springbootmybatisplus.entity.Student;

import java.util.List;

/**
 * <pre>
 * @desc: Mapper 接口
 * @author: cao_wencao
 * @date: 2019-08-21 17:42
 * @version: 1.0
 * </pre>
 */
public interface StudentDao extends BaseMapper<Student> {

    List<Student> selectAll();

}

