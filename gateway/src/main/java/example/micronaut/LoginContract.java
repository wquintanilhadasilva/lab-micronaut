package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

public interface LoginContract {
	
	public HttpResponse<BearerAccessRefreshToken> login(UsernamePasswordCredentials credential); 
	
	public String whoami();

}
