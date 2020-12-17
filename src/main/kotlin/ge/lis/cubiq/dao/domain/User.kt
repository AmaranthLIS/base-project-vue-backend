package ge.lis.cubiq.dao.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import java.time.LocalDateTime

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 16.12.2020  * Time: 17:43
 */
@Entity
@Table(name = "users")
data class User(
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  var id: Long,
  var email: String,
  var username: String,
  @JsonIgnore
  var password: String,
  var activated: Boolean,
  var createdAt: LocalDateTime,
  var updatedAt: LocalDateTime,
  var role: Int, //0 = super, 1 admin, 2 oper, 3 user
)
/*{
  constructor(name: String) : this(0, name)
  @Transient
  var employees: MutableList<Employee> = mutableListOf()
}*/

data class AuthUser(
  val username: String,
  val password: String,
)
