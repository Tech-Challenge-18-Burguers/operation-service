package br.com.eighteenburguers.operation.infra.queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.eighteenburguers.operation.adapter.request.OrderRequest;

@Configuration
public class MessageContextConfiguration {

	@Bean
	ContextConfiguration contextConfiguration() {
		ContextConfiguration configuration = new ContextConfiguration();
		configuration.configure("ORDER", OrderRequest.class);
		return configuration;
	}
}
