package com.thinkingcao.springbootmybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fengwenyi.javalib.util.StringUtils;
import com.thinkingcao.springbootmybatisplus.business.AppBusiness;
import com.thinkingcao.springbootmybatisplus.entity.City;
import com.thinkingcao.springbootmybatisplus.entity.Idcard;
import com.thinkingcao.springbootmybatisplus.entity.Student;
import com.thinkingcao.springbootmybatisplus.enums.GenderEnum;
import com.thinkingcao.springbootmybatisplus.service.MPCityService;
import com.thinkingcao.springbootmybatisplus.service.MPStudentService;
import io.swagger.annotations.Api;
import net.iutil.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 * @desc:  Controller、基础增删改查demo
 * @author: cao_wencao
 * @date: 2019-08-21 17:35
 * @version: 1.0
 * </pre>
 */
@RestController
@RequestMapping(value = "/app", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(tags = "App 测试示例")
public class AppController {

    @Autowired(required=false)
    private MPCityService mpCityService;

    @Autowired
    private AppBusiness appBusiness;

    @Autowired(required=false)
    private MPStudentService mpStudentService;

    // 查询所有城市
    @GetMapping("/queryCityAll")
    public ApiResult queryCityAll() {
        List<City> cities = mpCityService.queryCityAll();
        return ApiResult.success(cities);
    }


    // 添加城市
    @PostMapping("/addCity")
    public ApiResult addCity(String name) {
        if (StringUtils.isEmpty(name)) {
            return ApiResult.error();
        }
        boolean rs = mpCityService.addCity(new City().setName(name));
        if (rs) {
            return ApiResult.success();
        }
        return ApiResult.error();
    }

    // 添加学生
    @PostMapping("/addStudent")
    public ApiResult addStudent(String name, Integer age, String gender, String info, String idCardCode, String cityName) {

        // 检验参数
        if (StringUtils.isEmpty(name) || age == null || StringUtils.isEmpty(gender) || StringUtils.isEmpty(info)
                || StringUtils.isEmpty(idCardCode) || StringUtils.isEmpty(cityName)) {
            return ApiResult.error();
        }

        // 获取GenderEnum
        GenderEnum genderEnum = GenderEnum.getEnumByDesc(gender);

        // student
        Student student = new Student()
                .setName(name)
                .setAge(age)
                .setGender(genderEnum)
                .setInfo(info);

        // city
        City city = new City().setName(cityName);

        // idCard
        Idcard idcard = new Idcard().setCode(idCardCode);

        // service
        boolean rs = appBusiness.addStudent(student, city, idcard);
        if (rs) {
            return ApiResult.success();
        }
        return ApiResult.error();
    }

    // 分页查询学生
    @GetMapping("/queryStudentByPage/{currentPage}")
    public ApiResult queryStudentByPage(@PathVariable("currentPage") Long currentPage) {
        if (currentPage == null) {
            return ApiResult.error();
        }
        IPage<Student> studentIPage = mpStudentService.queryStudentByPage(currentPage);
        return ApiResult.success(studentIPage);
    }
}

