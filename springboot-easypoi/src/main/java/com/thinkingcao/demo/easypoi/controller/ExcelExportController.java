package com.thinkingcao.demo.easypoi.controller;

import com.thinkingcao.demo.easypoi.entity.User;
import com.thinkingcao.demo.easypoi.service.UserService;
import com.thinkingcao.demo.easypoi.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <pre>
 * &#64;author cao_wencao
 * &#64;date 2018年12月13日 下午6:16:59
 * </pre>
 */
@RestController
@RequestMapping("/excel/export")
@Slf4j
public class ExcelExportController {
	@Autowired
	private UserService userService;

	@GetMapping("/exportExcel")
	public void export(HttpServletResponse response) {
		System.out.println(1);
		// 模拟从数据库获取需要导出的数据
		List<User> personList = userService.findAll();
		// 导出操作
		ExcelUtils.exportExcel(personList, "easypoi导出功能", "导出sheet1", User.class, "测试user.xls", response);
		log.info("导出Excel数据成功");
	}
}
