package hello.world.resource;

import hello.world.resource.routes.GreetingsControllerRoutes;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;

@Controller("/greetings")
public class GreetingsController implements GreetingsControllerRoutes{
	
	@Value("${greeting.message}") // definida em yaml
	private String greeting;
	
	@Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

	@Override
	@Produces(MediaType.TEXT_PLAIN)
	public HttpResponse<String> greeting(String name) {
		return HttpResponse.ok(greeting + ", " + name + "!");
	}
}
