package ge.lis.cubiq.dao.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import java.sql.Timestamp
import java.time.Instant
//import javax.persistence.*
import java.time.LocalDateTime

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 16.12.2020  * Time: 17:43
 */
const val DATE_PATTERN = "yyyy-MM-dd HH:mm:ss"
const val DATE_TZ = "UTC"

data class User(
    var id: Long = 0,
    var email: String = "",
    var username: String = "",
    @JsonIgnore
    var password: String = "",
    var activated: Boolean = false,
//    @JsonSerialize(using = LocalDateSerializer::class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") //.SSSZ ,locale = "en_GB"
//      @JsonDeserialize(using = MyCustomDeserializer.class)
//      @JsonSerialize(using = MyCustomSerializer.class)
    @JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TZ)
    var createdAt: Instant = Instant.now(), //Timestamp.from(Instant.now()),
    @JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TZ)
    var updatedAt: Instant = Instant.now(), //Timestamp.from(Instant.now()),
    var role: Int = 3, //0 = super, 1 admin, 2 oper, 3 user
    @JsonFormat(pattern = DATE_PATTERN, timezone = DATE_TZ)
    var lastAuth: Instant? = null,
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
