package com.thinkingcao.modules.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MemeberMapper {
	//根据id获取记录
	public Map findObjectById(@Param("id")Integer id);
	
}