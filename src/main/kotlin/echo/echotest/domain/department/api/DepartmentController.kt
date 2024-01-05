package echo.echotest.domain.department.api

import echo.echotest.common.dto.ApiResponse
import echo.echotest.domain.jobHistory.api.dto.DepartmentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/departments")
class DepartmentController(private val departmentFacade: DepartmentFacade) {
    @Operation(summary = "부서 조회")
    @GetMapping("/{departmentId}/location")
    fun findOneWithLocation(
        @PathVariable(required = true)
        @Schema(description = "department id", example = "90")
        departmentId: Long,
    ): ApiResponse<DepartmentResponse> =
        ApiResponse.success(DepartmentResponse.of(departmentFacade.findDepartment(departmentId)))
}