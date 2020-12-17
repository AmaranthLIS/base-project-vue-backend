package ge.lis.cubiq.web

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.net.URI

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 15.12.2020  * Time: 11:27
 */

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller
class ContentController {

  /*@Get("/", consumes = [MediaType.TEXT_HTML])
  suspend fun home(): HttpResponse<Any> {
    return HttpResponse.redirect(URI.create("/index.html"))
  }*/

//  @Produces(MediaType.TEXT_HTML)
  @Get("/view", consumes = [MediaType.TEXT_HTML])
  fun view(): HttpResponse<Any> {
    return HttpResponse.redirect(URI.create("/index.html"))
  }
}
