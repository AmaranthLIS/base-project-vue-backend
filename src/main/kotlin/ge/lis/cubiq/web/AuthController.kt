package ge.lis.cubiq.web

import ge.lis.cubiq.dao.UserDao
import ge.lis.cubiq.dao.domain.AuthUser
import ge.lis.cubiq.dao.domain.SortingAndOrderArguments
import ge.lis.cubiq.dao.domain.User
import ge.lis.cubiq.dao.repository.UserRepository
import ge.lis.cubiq.service.PasswordEncoderService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.reactivex.Single
import mu.KotlinLogging
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand
import javax.inject.Inject

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 17.12.2020  * Time: 02:19
 */
@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api/authentication")
class AuthController {

  private val LOG = KotlinLogging.logger {}

  @Inject
  lateinit var jdbi : Jdbi


  @ExecuteOn(TaskExecutors.IO)
  @Post("/auth")
  fun auth(user: AuthUser): HttpResponse<Any> {
    return HttpResponse.ok("auth= $user")
  }


  @Post("/signup")
  fun signup(user: AuthUser): HttpResponse<Any> {
    return HttpResponse.ok("sing-up= $user")
  }

  @Post("/forgot")
  fun forgot(email: String): HttpResponse<Any> {
    return HttpResponse.ok("forgot this $email")
  }

  @Get("/authFailed")
  fun authFail(): HttpResponse<Any> {
    return HttpResponse.ok(mapOf("error" to "incorrect username or password"))
  }


//  @Inject
//  lateinit var userRepository: UserRepository
  @Inject
  lateinit var passwordEncoder: PasswordEncoderService


  @Get("/check")
  fun tmp(): HttpResponse<Any> {
    LOG.info { "checking" }
    LOG.info { "test hash = ${passwordEncoder.encode("test")}" }

    val userDao = jdbi.onDemand<UserDao>()
    val result = userDao.getUsers()
//    return Single.just("hi - $result");

//    userRepository.save(User(email = "temp@mail.com", username = "test", password = passwordEncoder.encode("test")))
    return HttpResponse.ok("hi - $result")
  }
}
