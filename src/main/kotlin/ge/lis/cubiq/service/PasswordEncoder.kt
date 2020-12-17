package ge.lis.cubiq.service

import edu.umd.cs.findbugs.annotations.NonNull

import javax.validation.constraints.NotBlank

/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 18.12.2020  * Time: 02:18
 */
interface PasswordEncoder {
  fun encode(@NotBlank @NonNull rawPassword: String): String

  fun matches(@NotBlank @NonNull rawPassword: String, @NotBlank @NonNull encodedPassword: String): Boolean
}
