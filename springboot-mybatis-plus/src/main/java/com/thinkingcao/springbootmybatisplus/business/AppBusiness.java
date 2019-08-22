package com.thinkingcao.springbootmybatisplus.business;

import com.thinkingcao.springbootmybatisplus.entity.City;
import com.thinkingcao.springbootmybatisplus.entity.Idcard;
import com.thinkingcao.springbootmybatisplus.entity.Student;

/**
 * <pre>
 * @desc:  数据库表关联逻辑处理接口定义
 * @author: cao_wencao
 * @date: 2019-08-21 17:28
 * @version: 1.0
 * </pre>
 */
public interface AppBusiness {
    public boolean addStudent(Student student, City city, Idcard idcard);
}
