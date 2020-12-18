package ge.lis.cubiq.dao

import ge.lis.cubiq.dao.domain.AuthUser
import org.jdbi.v3.sqlobject.statement.SqlQuery

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 17.12.2020  * Time: 23:53
 */

interface UserDao {
  @SqlQuery("SELECT *  FROM users")
  fun getUsers(): List<AuthUser>

//  @SqlUpdate("INSERT INTO customers (username, fNameEng) VALUES (:user.username, :user.fNameEng)")
//  fun insertUser(user: Customer)

//  @SqlQuery("select username from customers order by id")
//  @Reversed
//  @SingleValue
//  fun singleRow(): List<String?>
}

data class Customer(val username: String?, val fName: String?, val lName: String?, val fNameEng: String?, val lNameEng: String?)
