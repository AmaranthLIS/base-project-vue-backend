package ge.lis.cubiq.middleware

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import javax.inject.Singleton
import org.reactivestreams.Publisher

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 01:59
 */
@Singleton
class AuthenticationProviderUserPassword : AuthenticationProvider {
  override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {
    return Flowable.create({ emitter: FlowableEmitter<AuthenticationResponse> ->
      if (authenticationRequest.identity == "sherlock" && authenticationRequest.secret == "password") {//todo use DB
        val userDetails = UserDetails(authenticationRequest.identity as String, ArrayList())
        emitter.onNext(userDetails)
        emitter.onComplete()
      } else {
        emitter.onError(AuthenticationException(AuthenticationFailed()))
      }
    }, BackpressureStrategy.ERROR)
  }
}
