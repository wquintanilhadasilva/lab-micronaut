package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

@Controller("/security")
public class LoginController {
	
	private LoginContract loginService;
	
	public LoginController(LoginContract loginService) {
		this.loginService = loginService;
	}
	
	@Post("/login")
	@Secured(SecurityRule.IS_ANONYMOUS)
	@Produces(MediaType.APPLICATION_JSON)
	public HttpResponse<BearerAccessRefreshToken> login(UsernamePasswordCredentials credential){
		System.out.println("gateway login invoked");
		return this.loginService.login(credential);
	}
	
	@Get("/whoami")
	@Secured(SecurityRule.IS_AUTHENTICATED)
	@Produces(MediaType.APPLICATION_JSON)
	public String whoami() {
		System.out.println("quem sou eu?!");
		return loginService.whoami();
	}

}
