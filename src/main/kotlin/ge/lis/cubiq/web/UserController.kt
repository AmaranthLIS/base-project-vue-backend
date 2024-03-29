package ge.lis.cubiq.web

import ge.lis.cubiq.dao.UserDao
import ge.lis.cubiq.dao.domain.AuthUser
import ge.lis.cubiq.dao.domain.User
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.security.annotation.Secured
import mu.KotlinLogging
import java.security.Principal
import javax.inject.Inject

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 16.12.2020  * Time: 02:16
 */

@Secured("isAuthenticated()")
@Controller("/api/user")
class UserController {
  companion object {
    val LOG = KotlinLogging.logger {}
  }

  @Inject
  lateinit var userDao : UserDao

  @Get("/auth")//temp
  fun auth(principal: Principal): Any {
//    LOG.info { (principal as UserDetails).getAttributes("id") }
    return principal
  }

  @Get("/account")
  fun get(principal: Principal): HttpResponse<Any> {
    return HttpResponse.ok( userDao.get(principal.name) )
  }

  @Put("/account")
  fun update(principal: Principal, userDTO: User): HttpResponse<Any> {
    LOG.debug { "updateAccount = $principal" }
    //valid userDTO
//    userDao.updateAccount(userDTO)
    return HttpResponse.ok("update = $userDTO")
  }

  @Post("/account")
  fun create(principal: Principal, user: AuthUser): HttpResponse<Any> {
    LOG.debug { "createAccount = $principal" }
    //valid user
    userDao.createUpdateAccount(user)
    return HttpResponse.ok()
  }

  @Get("/list")
  fun list(): HttpResponse<Any> {
    return HttpResponse.ok(userDao.getAll())
  }

  @Post("/upload/avatar")
  fun uploadAvatar(principal: Principal): HttpResponse<Any> {
    //check file
//    userDao.updateAvatar(principal.name)
    return HttpResponse.ok("update = $principal")
  }

}
