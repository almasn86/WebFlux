package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ExampleHandler {
	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello, Spring Webflux Example!"));
	}

	public Mono<ServerResponse> helloFurther1(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello, Spring Webflux Example 1!"));
	}

	public Mono<ServerResponse> helloFurther2(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello, Spring Webflux Example 2!"));
	}

	public Mono<ServerResponse> helloFurther3(ServerRequest request) {
		String name = request.queryParam("name").get();
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello, " + name + "!"));
	}
	
	public Mono<ServerResponse> helloFurther4(ServerRequest request) {
		String name = "NoName";
		
		try {
			name = request.queryParam("name").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Map<String, String>> myAccountTable = new ArrayList<Map<String, String>>();
		Map<String, String> myAccountRow = new HashMap<>();
		myAccountRow.put("Name", name);
		myAccountRow.put("Salary", "1000");
		myAccountTable.add(myAccountRow);
		myAccountTable.add(myAccountRow);
		myAccountTable.add(myAccountRow);
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject(myAccountTable));
	}
}