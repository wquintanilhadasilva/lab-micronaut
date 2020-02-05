package example.micronaut;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

@Client(id = "security") 
@Requires(notEnv = Environment.TEST)
public interface LoginContractClient extends LoginContract{
	
	@Post("/login")
//	public Single<HttpResponse<?>> login(UsernamePasswordCredentials credential); 
	public HttpResponse<BearerAccessRefreshToken> login(UsernamePasswordCredentials credential); 
	
	@Get("/whoami/")
	public String whoami();

}
