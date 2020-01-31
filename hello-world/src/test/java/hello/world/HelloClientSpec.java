package hello.world;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import hello.world.clients.HelloClient;
import io.micronaut.test.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloClientSpec {
	
	@Inject
	HelloClient client;
	
	@Test
	public void testHelloWorldResponse() {
		assertEquals("Hello World", client.hello().blockingGet());
	}

}
