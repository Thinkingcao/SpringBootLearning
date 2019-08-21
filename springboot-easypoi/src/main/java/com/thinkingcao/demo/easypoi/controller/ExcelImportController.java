package com.thinkingcao.demo.easypoi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.thinkingcao.demo.easypoi.entity.User;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * &#64;author cao_wencao
 * &#64;date 2018年12月13日 下午6:17:10
 * </pre>
 */
@RestController
@RequestMapping("/excel/import")
@Slf4j
public class ExcelImportController {

	@PostMapping("/importExcel")
	public String importExcel2(@RequestParam("file") MultipartFile file) {
		ImportParams importParams = new ImportParams();
		// 数据处理
		importParams.setHeadRows(1);
		importParams.setTitleRows(1);
		// 需要验证
		importParams.setNeedVerfiy(false);       
        
		try {
			ExcelImportResult<User> result = ExcelImportUtil.importExcelMore(file.getInputStream(), User.class,
					importParams);
			List<User> userList = result.getList();
			for (User User : userList) {
				// System.out.println(User);
				log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(User));
				//TODO 将导入的数据做保存数据库操作
			}
			log.info("从Excel导入数据一共 {} 行 ", userList.size());
		} catch (IOException e) {
			log.error("导入失败：{}", e.getMessage());
		} catch (Exception e1) {
			log.error("导入失败：{}", e1.getMessage());
		}
		return "导入成功";
	}
}
