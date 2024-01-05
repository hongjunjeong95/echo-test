package echo.echotest.domain.employee.api

import echo.echotest.common.dto.ApiResponse
import echo.echotest.domain.employee.api.dto.EmployeeResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController(private val employeeFacade: EmployeeFacade) {
    @Operation(summary = "사원 조회")
    @GetMapping("/{employeeId}")
    fun findOne(
        @PathVariable(required = true)
        @Schema(description = "employee id", example = "1")
        employeeId: Long,
    ): ApiResponse<EmployeeResponse> =
        ApiResponse.success(EmployeeResponse.of(employeeFacade.findEmployee(employeeId)))
}