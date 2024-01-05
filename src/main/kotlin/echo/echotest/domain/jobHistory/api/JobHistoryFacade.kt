package echo.echotest.domain.jobHistory.api

import echo.echotest.common.dto.PaginationQuery
import echo.echotest.domain.employee.service.EmployeeService
import echo.echotest.domain.department.api.service.DepartmentService
import echo.echotest.domain.jobHistory.api.dto.FindDepartmentsQueryDto
import echo.echotest.domain.jobHistory.persistent.JobHistory
import echo.echotest.domain.jobHistory.service.JobHistoryService
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JobHistoryFacade(
    private val jobHistoryService: JobHistoryService,
    private val employeeService: EmployeeService,
) {
    @Transactional
    fun findJobHistories(paginationQuery: PaginationQuery, query: FindDepartmentsQueryDto): Page<JobHistory> {
        val employee = employeeService.findByIdOrThrow(query.employeeId)
        return jobHistoryService.findManyByEmployee(employee, paginationQuery.page,paginationQuery.size)
    }

}