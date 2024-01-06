package echo.echotest.domain.employee.api.dto

import io.swagger.v3.oas.annotations.media.Schema

data class UpdateEmployeeBodyDto(
    @Schema(description = "first name", example = "new first name", required = false)
    var firstName: String?,

    @Schema(description = "lastName", example = "new last name", required = false)
    var lastName: String?,

    @Schema(description = "email", example = "email", required = false)
    var email: String?,

    @Schema(description = "phone number", example = "010-1212-1212", required = false)
    var phoneNumber: String?,
)