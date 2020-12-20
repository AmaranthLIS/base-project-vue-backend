package ge.lis.cubiq.dao.domain

import com.fasterxml.jackson.annotation.JsonIgnore
//import javax.persistence.*
import java.time.LocalDateTime

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 16.12.2020  * Time: 17:43
 */
data class User(
  var id: Long = 0,
  var email: String = "",
  var username: String = "",
  @JsonIgnore
  var password: String = "",
  var activated: Boolean = false,
  var createdAt: LocalDateTime = LocalDateTime.now(),
  var updatedAt: LocalDateTime = LocalDateTime.now(),
  var role: Int = 3, //0 = super, 1 admin, 2 oper, 3 user
  var lastAuth:  LocalDateTime? = null,
)
/*{
  constructor(name: String) : this(0, name)
  @Transient
  var employees: MutableList<Employee> = mutableListOf()
}*/

data class AuthUser(
  var username: String = "",
  var password: String = "",
  var email: String? = null,
  var id: Long? = null,
)

//data class Customer(val username: String?, val fName: String?, val lName: String?, val fNameEng: String?, val lNameEng: String?)
