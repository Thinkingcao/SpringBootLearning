package com.thinkingcao.demo.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * <pre>
 * &#64;author cao_wencao
 * &#64;date 2018年12月13日 下午4:50:18
 * </pre>
 */
@ExcelTarget("20")
@Setter
@Getter
@ToString
public class User implements java.io.Serializable{
	@Excel(name = "id", width=15)
	@NotBlank(message = "该字段不能为空")
	private Integer id;

	@Excel(name = "姓名", orderNum = "0", width=30)
	private String name;

	@Excel(name = "性别", replace = { "男_1", "女_2" }, orderNum = "1", width=30)
	private String sex;

	@Excel(name = "生日", exportFormat = "yyyy-MM-dd",  orderNum = "2", width=30)
	private Date birthday;



}
