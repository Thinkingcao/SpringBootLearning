package com.thinkingcao.modules.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkingcao.modules.mapper.MemeberMapper;

@Controller
@RequestMapping("/test")
public class TestController {
	@Resource
	private MemeberMapper memeberMapper = null;

	@RequestMapping("/one")
	@ResponseBody
	public Map testdb() {
		return memeberMapper.findObjectById(1);
	}
}