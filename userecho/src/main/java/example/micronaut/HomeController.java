package example.micronaut;

import java.security.Principal;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

//@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/home")
public class HomeController {

	@Secured(SecurityRule.IS_AUTHENTICATED)
	@Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String index()
    {
        return "HomeController.index()";
    }
    
	@Secured(SecurityRule.IS_AUTHENTICATED)
    @Get("/username")
    @Produces(MediaType.TEXT_PLAIN)
    public String username(Principal principal)
    {
    	System.out.println("home.username");
        return principal.getName();
    }
    
}
