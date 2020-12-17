package ge.lis.cubiq.dao.domain

import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero
/**
 * Created by
 * @Author: lis, Luganskiy Igor, foxigs@gmail.com
 * Date: 17.12.2020  * Time: 19:00
 */

data class SortingAndOrderArguments (
    @field:PositiveOrZero
    val offset: Int? = null,

    @field:Positive
    val max: Int? = null,

    @field:Pattern(regexp = "id|name")
    val sort: String? = null,

    @field:Pattern(regexp = "asc|ASC|desc|DESC")
    val order: String? = null
)
