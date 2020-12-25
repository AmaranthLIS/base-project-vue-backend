package ge.lis.cubiq.dao

import ge.lis.cubiq.dao.domain.AuthUser
import ge.lis.cubiq.dao.domain.User
import ge.lis.cubiq.dao.repository.UserRepository
import ge.lis.cubiq.exception.Err.USER_NOT_FOUND
import ge.lis.cubiq.exception.Err.USER_WRONG_PASSWORD
import ge.lis.cubiq.service.PasswordEncoderService
import mu.KotlinLogging
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.kotlin.onDemand
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 17.12.2020  * Time: 23:53
 */

@Singleton
class UserDao {
  companion object {
    val LOG = KotlinLogging.logger {}
  }

  @Inject
  lateinit var jdbi : Jdbi

  @Inject
  lateinit var passwordEncoder: PasswordEncoderService


  fun get(username: String) : User? {
    val userDao = jdbi.onDemand<UserRepository>()
    return userDao.findByName(username)
  }

  fun tryAuth(rawPassword: String, user: User?): String? {
    if (rawPassword.isBlank() || null == user) {
      LOG.warn { "attempt find user" }
      return USER_NOT_FOUND
    }
    if (! passwordEncoder.matches(rawPassword, user.password)) {
      LOG.warn { "attempt auth user=${user.username}, wrong password" }
      return USER_WRONG_PASSWORD
    }
    val userDao = jdbi.onDemand<UserRepository>()
    userDao.updateLastAuth(user.id)
    LOG.info { "success auth user=${user.username}" }
    return null
  }

  fun createUser(user: AuthUser) : Boolean {
    val userDao = jdbi.onDemand<UserRepository>()
    val createdUser = userDao.save(User(
        email = user.email ?: "${user.username}@mail.def",
        username = user.username,
        password = passwordEncoder.encode(user.password) ))
    return createdUser > 0
  }

  fun getAll(): List<User> {
    return jdbi.onDemand<UserRepository>().getAll()
  }

  fun createUpdateAccount(user: AuthUser) {
    user.password = passwordEncoder.encode(user.password)
    return jdbi.onDemand<UserRepository>().insertUser(user)
  }
}
