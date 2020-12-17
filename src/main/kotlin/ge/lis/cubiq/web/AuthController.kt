package ge.lis.cubiq.web

import ge.lis.cubiq.dao.domain.AuthUser
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.net.URI
import javax.validation.constraints.NotBlank

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 17.12.2020  * Time: 02:19
 */
@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/api/authentication")
class AuthController {

//  @Get("/auth", consumes = [MediaType.APPLICATION_FORM_URLENCODED])

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
}
