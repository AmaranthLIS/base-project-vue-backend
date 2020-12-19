package ge.lis.cubiq.web

import ge.lis.cubiq.dao.UserDao
import ge.lis.cubiq.dao.domain.AuthUser
import ge.lis.cubiq.dao.domain.SortingAndOrderArguments
import ge.lis.cubiq.dao.domain.User
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import mu.KotlinLogging
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
  lateinit var userDao : UserDao



  @ExecuteOn(TaskExecutors.IO)
  @Post("/auth")
  fun auth(user: AuthUser): HttpResponse<Any> {
    return HttpResponse.ok(user)
  }


  @Post("/signup")
  fun signup(user: AuthUser): HttpResponse<Any> {
    //todo check user
    LOG.info { "sing-up $user" }
    return HttpResponse.ok(userDao.createUser(user))
  }

  @Post("/forgot")
  fun forgot(email: String): HttpResponse<Any> {
    return HttpResponse.ok("forgot this $email")
  }

  @Get("/authFailed")
  fun authFail(): HttpResponse<Any> {
    return HttpResponse.ok(mapOf("error" to "incorrect username or password"))
  }

}
