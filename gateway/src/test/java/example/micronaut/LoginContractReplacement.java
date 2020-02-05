package example.micronaut;

import java.util.ArrayList;

import javax.inject.Singleton;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.HttpResponse;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

@Requires(env = Environment.TEST)
@Singleton
public class LoginContractReplacement implements LoginContract{

	@Override
	public HttpResponse<BearerAccessRefreshToken> login(UsernamePasswordCredentials credential) {
		BearerAccessRefreshToken token = new BearerAccessRefreshToken();
		token.setUsername("filho amado do pai");
		token.setRoles(new ArrayList<String>());
		HttpResponse<BearerAccessRefreshToken> response = HttpResponse.ok(token); 
		return response;
	}

	@Override
	public String whoami() {
		return "filho amado do pai";
	}

}
