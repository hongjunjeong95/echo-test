package echo.echotest.domain.jobHistory.api.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min

data class FindDepartmentsQueryDto(
    @Schema(description = "employee id", example = "101")
    @field:Min(value = 1, message = "employeeId는 1 이상이어야 합니다.")
    val employeeId: Long,
)