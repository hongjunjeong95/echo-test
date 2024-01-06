package echo.echotest.domain.employee.api

import echo.echotest.common.dto.ApiResponse
import echo.echotest.domain.employee.api.dto.EmployeeResponse
import echo.echotest.domain.employee.api.dto.IncreaseSalaryQueryDto
import echo.echotest.domain.employee.api.dto.UpdateEmployeeBodyDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController(
    private val employeeFacade: EmployeeFacade,
    ) {
    @Operation(summary = "사원 조회")
    @GetMapping("/{employeeId}")
    fun findOne(
        @PathVariable(required = true)
        @Schema(description = "employee id", example = "1")
        employeeId: Long,
    ): ApiResponse<EmployeeResponse> =
        ApiResponse.success(EmployeeResponse.of(employeeFacade.findEmployee(employeeId)))

    @Operation(summary = "임금 인상")
    @PutMapping("/increase-department")
    fun increaseSalaryPercent(
        query: IncreaseSalaryQueryDto
    ) =
        ApiResponse.success((employeeFacade.increaseSalaryPercent(query.departmentId, query.salaryPercent)))

    @Operation(summary = "사원 데이터 수정")
    @PutMapping("/{employeeId}")
    fun update(
        @PathVariable
        @Schema(description = "team data id", example = "200")
        employeeId: Long,

        @RequestBody
        body: UpdateEmployeeBodyDto
    ): ApiResponse<Unit> =
        ApiResponse.success(employeeFacade.updateEmployee(employeeId, body))
}