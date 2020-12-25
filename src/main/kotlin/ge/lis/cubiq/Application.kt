package ge.lis.cubiq

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.Micronaut.*
import io.micronaut.runtime.event.annotation.EventListener
import mu.KotlinLogging
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin
import org.jdbi.v3.postgres.PostgresPlugin
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
  companion object {
    val logger = KotlinLogging.logger {}
  }

  @Inject
  lateinit var jdbi : Jdbi

  @EventListener
  internal fun onStartupEvent(event: StartupEvent) {//ShutdownEvent, HttpRequestTerminatedEvent, HttpRequestReceivedEvent
    jdbi = jdbi.installPlugin(SqlObjectPlugin())
        .installPlugin(KotlinPlugin())
        .installPlugin(KotlinSqlObjectPlugin())
//        .installPlugin(Jackson2Plugin())
        .installPlugin(PostgresPlugin())

    logger.info { "StartupEvent - ${event.toString().substring(range = 27..38)}" } //        .getConfig(Jackson2Config.class).setMapper(Lang)
  }
}


typealias Tag = Pair<String, Any?>

@JsonDeserialize
data class Lang(var en: String? = null, var ru: String? = null) {}
//@RegisterMapper divided into @RegisterRowMapper and @RegisterColumnMapper.
