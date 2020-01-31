package hello.world;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import hello.world.resource.routes.GreetingsControllerRoutes;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class GreetingsControllerTest {
	
	@Inject
	EmbeddedServer server;
	
	@Inject
	@Client("/greetings")
	GreetingsControllerRoutes client;
	
	@Value("${greeting.message}")
	String greetingMessage;
	
	@Test
	public void greetingsByNameTest() {
		HttpResponse<String> response = client.greeting("joão");
		String responsetext = response.body();
		assertEquals(responsetext, greetingMessage + ", joão!");
	}

}
