package com.vshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Spring Boot 启动类
 * @author ganzhigang
 * 时间：2017年4月26日 下午3:26:15
 */
@SpringBootApplication
@ServletComponentScan // 使得spring能够扫描到我们自己编写的servlet和filter(针对druid) === 针对的是 启动druid 的监控
public class WebApplicationConfiguration extends SpringBootServletInitializer{

	/**
	 * war 包启动入口
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebApplicationConfiguration.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebApplicationConfiguration.class, args);
	}
	
}
