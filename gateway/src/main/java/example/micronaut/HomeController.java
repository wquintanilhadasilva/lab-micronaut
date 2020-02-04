package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/home")
public class HomeController {
	
	private HomeContract homeClient;

	public HomeController(HomeContract homeClient) {
		this.homeClient = homeClient;
	}
	
	@Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String index()
    {
		System.out.println("home.index()");
//		return "home.index";
        return homeClient.index();
    }
    
    @Get("/username")
    @Produces(MediaType.TEXT_PLAIN)
    public String username()
    {
    	System.out.println("home.username");
//    	return "home.username";
        return homeClient.username();
    }

}
