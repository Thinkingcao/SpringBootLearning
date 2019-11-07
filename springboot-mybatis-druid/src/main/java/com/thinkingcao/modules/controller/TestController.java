package com.thinkingcao.modules.controller;

import com.thinkingcao.modules.mapper.MemeberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

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