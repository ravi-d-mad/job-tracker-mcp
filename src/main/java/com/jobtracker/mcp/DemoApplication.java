package com.jobtracker.mcp;

import com.jobtracker.mcp.model.JobTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ToolCallbackProvider jobToolsProvider(JobTools tools) {
		return MethodToolCallbackProvider.builder().toolObjects(tools).build();
	}
}
