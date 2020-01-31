package hello.world;

import javax.inject.Inject;
import io.micronaut.context.annotation.Property;

import org.junit.jupiter.api.Test;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloControllerSpec {

	@Inject
	EmbeddedServer server;
	
	@Inject
	@Client("/")
	HttpClient client;
	
	@Test
	void testHelloWorldResponse() {
		String response = client.toBlocking()
				.retrieve(HttpRequest.GET("/hello"));
		assertEquals("Hello World", response);
	}
	
}
