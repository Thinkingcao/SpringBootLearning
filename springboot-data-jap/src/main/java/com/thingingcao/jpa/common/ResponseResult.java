package com.thingingcao.jpa.common;

public class ResponseResult {
	private Integer state;
	private String msg;
	private Object data;

	public ResponseResult() {
		this.state = 200;
		this.msg = "成功";
	}

	public ResponseResult(Integer state, String msg) {
		this.state = state;
		this.msg = msg;
	}

	public ResponseResult(Integer state, String msg, Object data) {
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
