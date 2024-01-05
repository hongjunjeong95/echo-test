package echo.echotest.domain.jobHistory.api

import echo.echotest.common.dto.ApiResponse
import echo.echotest.common.dto.PaginationQuery
import echo.echotest.domain.department.api.DepartmentFacade
import echo.echotest.domain.jobHistory.api.dto.FindDepartmentsQueryDto
import echo.echotest.domain.jobHistory.api.dto.JobHistoriesResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/job-histories")
class JobHistoryController(private val jobHistoryFacade: JobHistoryFacade) {
    @Operation(summary = "사원 이력 조회")
    @GetMapping()
    fun findMany(
        paginationQuery: PaginationQuery,
        query: FindDepartmentsQueryDto
    ): ApiResponse<JobHistoriesResponse> =
        ApiResponse.success(JobHistoriesResponse.of(jobHistoryFacade.findJobHistories(paginationQuery,query)))
}