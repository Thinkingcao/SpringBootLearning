package com.thinkingcao.modules.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MemeberMapper {
	//根据id获取记录
	public Map findObjectById(@Param("id")Integer id);
	
}