package ge.lis.cubiq.service

//import edu.umd.cs.findbugs.annotations.NonNull
//import javax.validation.constraints.NotBlank

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 02:18
 */
interface PasswordEncoderService {
  fun encode(rawPassword: String): String

  fun matches(rawPassword: String, encodedPassword: String): Boolean //@NotBlank @NonNull
}
