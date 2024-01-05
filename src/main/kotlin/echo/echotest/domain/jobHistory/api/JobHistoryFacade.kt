package echo.echotest.domain.jobHistory.api

import echo.echotest.common.dto.PaginationQuery
import echo.echotest.domain.employee.service.EmployeeService
import echo.echotest.domain.jobHistory.service.JobHistoryService
import echo.echotest.domain.jobHistory.api.dto.FindJobHistoriesQueryDto
import echo.echotest.domain.jobHistory.persistent.JobHistory
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JobHistoryFacade(
    private val jobHistoryService: JobHistoryService,
    private val employeeService: EmployeeService,
) {
    @Transactional
    fun findJobHistories(paginationQuery: PaginationQuery, query: FindJobHistoriesQueryDto): Page<JobHistory> {
        val employee = employeeService.findByIdOrThrow(query.employeeId)
        return jobHistoryService.findManyByEmployee(employee, paginationQuery.page,paginationQuery.size)
    }

}