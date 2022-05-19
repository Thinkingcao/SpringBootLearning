package com.thinkingcao.redis.ratelimiter.response;

public class HealthResponse {
	public static final String HEALTHY_STATUS = "OK";
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}