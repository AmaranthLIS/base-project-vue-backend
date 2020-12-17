package ge.lis.cubiq.web

import io.micronaut.core.io.ResourceResolver
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.types.files.StreamedFile
import java.util.*
import javax.inject.Inject

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 15.12.2020  * Time: 19:25
 */
@Controller("/api/bundle")
class BundleController {

  @Inject
  var resourceResolver: ResourceResolver? = null

//  @Error(global = true, status = HttpStatus.NOT_FOUND)
  @Produces(MediaType.TEXT_HTML)
  @Get("/")
  fun forward(): Optional<StreamedFile?>? {
    return resourceResolver?.getResource("classpath:static/index.html")?.map { ( StreamedFile(it)) }
  }
}
