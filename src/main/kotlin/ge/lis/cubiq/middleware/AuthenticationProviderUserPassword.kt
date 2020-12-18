package ge.lis.cubiq.middleware

import ge.lis.cubiq.service.PasswordEncoderService
import io.micronaut.http.HttpRequest
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.security.authentication.*
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 01:59
 */
@Singleton
class AuthenticationProviderUserPassword : AuthenticationProvider {

//  @Inject
//  lateinit var userRepository: UserRepository
  @Inject
  lateinit var passwordEncoder: PasswordEncoderService

  @Inject
  @Named(TaskExecutors.IO)
  lateinit var executorService: ExecutorService


  private val scheduler: Scheduler by lazy {
    Schedulers.from(executorService)
  }

  override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {
    return Flowable.create({ emitter: FlowableEmitter<AuthenticationResponse> ->
//      UserState user = fetchUserState(authenticationRequest) //todo go to DB
      if (authenticationRequest.identity == "sherlock" && authenticationRequest.secret == "password") {
        val userDetails = UserDetails(authenticationRequest.identity as String, listOf("ROLE_ADMIN"), mapOf())//ArrayList()
        emitter.onNext(userDetails)
        emitter.onComplete()
      } else {
        emitter.onError(AuthenticationException(AuthenticationFailed()))
      }
    }, BackpressureStrategy.ERROR)
        .subscribeOn(scheduler)
  }
}
