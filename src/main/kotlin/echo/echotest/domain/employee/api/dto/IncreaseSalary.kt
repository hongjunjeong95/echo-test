package echo.echotest.domain.employee.api.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min


data class IncreaseSalaryQueryDto(
    @Schema(description = "department id", example = "90")
    val departmentId: Long,

    @Schema(description = "salary percent", example = "10")
    @field:Min(value = 1, message = "임금 인상률은 무조건 1 이상이어야 합니다.")
    @field:Max(value = 100, message = "임금 인상률은 무조건 100 이하이어야 합니다.")
    val salaryPercent:Int
)