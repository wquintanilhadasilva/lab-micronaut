package security.module;

import java.security.Principal;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/whoami")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class SessionController {
	
	@Get("/")
	public String get(Principal principal) {
		return principal.getName();
	}

}
