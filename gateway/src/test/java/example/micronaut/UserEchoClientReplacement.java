package example.micronaut;

import javax.inject.Singleton;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.reactivex.Single;

@Requires(env = Environment.TEST)
@Singleton
public class UserEchoClientReplacement implements UsernameFetcher {

    @Override
    public Single<String> findUsername() {
        return Single.just("sherlock");
    }
}