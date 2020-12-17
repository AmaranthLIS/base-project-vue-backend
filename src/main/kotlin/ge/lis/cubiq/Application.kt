package ge.lis.cubiq

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
  build()
      .args(*args)
      .packages("ge.lis.cubiq")
      .start()
}

