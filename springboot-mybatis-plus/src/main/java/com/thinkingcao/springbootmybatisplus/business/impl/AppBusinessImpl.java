package com.thinkingcao.springbootmybatisplus.business.impl;

import com.fengwenyi.javalib.util.ExceptionUtil;
import com.thinkingcao.springbootmybatisplus.business.AppBusiness;
import com.thinkingcao.springbootmybatisplus.entity.City;
import com.thinkingcao.springbootmybatisplus.entity.Idcard;
import com.thinkingcao.springbootmybatisplus.entity.Student;
import com.thinkingcao.springbootmybatisplus.service.MPCityService;
import com.thinkingcao.springbootmybatisplus.service.MPIdcardService;
import com.thinkingcao.springbootmybatisplus.service.MPStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <pre>
 * @desc: 数据库表关联逻辑处理接口实现
 * @author: cao_wencao
 * @date: 2019-08-21 17:29
 * @version: 1.0
 * </pre>
 */
@Service
@Transactional
@Slf4j
public class AppBusinessImpl implements AppBusiness {

    @Resource
    private MPCityService mpCityService;

    @Resource
    private MPIdcardService mpIdcardService;

    @Resource
    private MPStudentService mpStudentService;

    @Override
    public boolean addStudent(Student student, City city, Idcard idcard) {
        ExceptionUtil.notNull(student, "Student must not null");
        ExceptionUtil.notNull(city, "City must not null");
        ExceptionUtil.notNull(idcard, "IdCard must not null");

        boolean rsAddCity = mpCityService.addCity(city);
        if (rsAddCity) {
            String cityName = city.getName();
            city = mpCityService.queryCityByName(cityName);
            if (city != null) {
                boolean rsAddIdCard = mpIdcardService.addIdCard(idcard);
                if (rsAddIdCard) {
                    String idCardCode = idcard.getCode();
                    idcard = mpIdcardService.queryIdCardByCode(idCardCode);
                    if (idcard != null) {
                        student.setCityId(city.getId()).setIdcardId(idcard.getId());
                        return mpStudentService.addStudent(student);
                    } else {
                        log.error("queryIdCardByCode 查询失败，idCardCode={}", idCardCode);
                    }
                } else {
                    log.error("增加IdCard失败：{}", idcard);
                }
            } else {
                log.error("queryCityByName 查询失败，name={}", cityName);
            }
        } else {
            log.error("增加City失败：{}", city);
        }

        return false;
    }
}

