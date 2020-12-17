package ge.lis.cubiq.web

import ge.lis.cubiq.dao.domain.User
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import java.security.Principal

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 16.12.2020  * Time: 02:16
 */
@Secured("isAuthenticated()")
@Controller("/api/user")
class UserController {

  @Get("/account")
  fun get(principal: Principal): HttpResponse<Any> {
    return HttpResponse.ok(principal)
  }

  @Post("/account")
  fun update(principal: Principal, user: User): HttpResponse<Any> {
    return HttpResponse.ok(" $principal / update = $user")
  }


}
