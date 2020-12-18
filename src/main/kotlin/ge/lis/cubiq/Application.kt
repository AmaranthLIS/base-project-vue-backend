package ge.lis.cubiq

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut.*
import io.micronaut.runtime.event.annotation.EventListener
import mu.KotlinLogging
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.jackson2.Jackson2Plugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin
import javax.inject.Inject
import javax.inject.Singleton

fun main(args: Array<String>) {
  build()
      .args(*args)
      .packages("ge.lis.cubiq")
      .start()
}

@Singleton
class SampleEventListener {
  private val logger = KotlinLogging.logger {}

  @Inject
  lateinit var jdbi : Jdbi

  @EventListener
  internal fun onStartupEvent(event: StartupEvent) {//ShutdownEvent, HttpRequestTerminatedEvent, HttpRequestReceivedEvent
    jdbi = jdbi.installPlugin(SqlObjectPlugin())
        .installPlugin(KotlinPlugin())
        .installPlugin(KotlinSqlObjectPlugin())
        .installPlugin(Jackson2Plugin())
//    jdbi.getConfig(Jackson2Config.class).setMapper(myObjectMapper)
    logger.info { "StartupEvent - ${event.toString().substring(range = 27..38)}" }
  }
}
