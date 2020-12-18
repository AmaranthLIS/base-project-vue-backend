package ge.lis.cubiq.dao.repository

import ge.lis.cubiq.dao.domain.SortingAndOrderArguments
import ge.lis.cubiq.dao.domain.User
//import javax.validation.constraints.NotBlank

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 00:04
 */
interface UserRepository {
  fun findById(id: Long): User?

  fun findByUsernameAndPassword(username: String, password: String): User?

  fun findByEmail(email: String): User?

  fun save(user: User): User

//  fun save(@NotBlank username: String): User

  fun deleteById(id: Long)

  fun findAll(args: SortingAndOrderArguments): List<User>

  fun updatePassword(id: Long,  password: String): Int

  fun updateActivated(id: Long, activated: Boolean): Int
}
