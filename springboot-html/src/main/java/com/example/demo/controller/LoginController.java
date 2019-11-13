package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * @Desc 
 * @author cao_wencao
 * @date 2019年11月13日 下午6:02:22
 * @version V1.0
 * </pre>
 */
@Controller
public class LoginController {

	
	@RequestMapping("/login")
	public String index() {
		return "login";
	}
}
