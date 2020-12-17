package ge.lis.cubiq.service

//import edu.umd.cs.findbugs.annotations.NonNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.inject.Singleton
import javax.validation.constraints.NotBlank

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 02:20
 */
@Singleton
class BCryptPasswordEncoderService: PasswordEncoder {

  val delegate: org.springframework.security.crypto.password.PasswordEncoder = BCryptPasswordEncoder()

  override fun encode(@NotBlank rawPassword: String): String {
    return delegate.encode(rawPassword)
  }

  override fun matches(@NotBlank rawPassword: String, @NotBlank encodedPassword: String): Boolean {
    return delegate.matches(rawPassword, encodedPassword)
  }
}
