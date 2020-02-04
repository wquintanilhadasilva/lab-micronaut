package example.micronaut;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client(id = "homeservice") 
@Requires(notEnv = Environment.TEST)
public interface HomeContractClient extends HomeContract{
	
	@Get("/home")
    public String index();
    
    @Get("/home/username")
    public String username();

}
