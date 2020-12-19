package ge.lis.cubiq.dao.repository

import ge.lis.cubiq.dao.domain.AuthUser
import ge.lis.cubiq.dao.domain.SortingAndOrderArguments
import ge.lis.cubiq.dao.domain.User
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

//import javax.validation.constraints.NotBlank

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 00:04
 */
interface UserRepository {

  @SqlQuery("SELECT * FROM users")
  fun getAll(): List<User>

//  @SqlUpdate("INSERT INTO customers (username, fNameEng) VALUES (:user.username, :user.fNameEng)")
//  fun insertUser(user: Customer)

  @SqlQuery("SELECT * FROM users WHERE `id` = ? LIMIT 1")
  fun findById(id: Long): User?

  @SqlQuery("SELECT * FROM users WHERE `username` = ? LIMIT 1")
  fun findByName(username: String): User?

  @SqlQuery("SELECT * FROM users WHERE `username` = ? AND `password` = ? LIMIT 1")
  fun findByUsernameAndPassword(username: String, password: String): User?

  @SqlQuery("SELECT * FROM users WHERE `email` = ? LIMIT 1")
  fun findByEmail(email: String): User?

  @SqlUpdate("INSERT INTO users (id, email, username, password, activated) VALUES (NULL, :email, :username, :password, :activated)")
  @GetGeneratedKeys("id")
  fun save(@BindBean user: User): Long

//  fun deleteById(id: Long)

//  fun findAll(args: SortingAndOrderArguments): List<User>

//  fun updatePassword(id: Long,  password: String): Int

//  fun updateActivated(id: Long, activated: Boolean): Int
}


//  @SqlQuery("select username from customers order by id")
//  @Reversed
//  @SingleValue
//  fun singleRow(): List<String?>
