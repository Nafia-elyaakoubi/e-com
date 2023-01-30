package org.sid.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/*@Bean // static config
	RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route((r)->r.path("/products/**").uri("http://localhost:8082/"))
				.route((r)->r.path("/customer/**").uri("http://localhost:8081/")).build();
	}*/

	@Bean // dynamic config
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties){
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, discoveryLocatorProperties);
	}
}
