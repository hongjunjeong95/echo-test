package echo.echotest.domain.jobHistory.service

import echo.echotest.common.service.CommonService
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.jobHistory.persistent.JobHistoryRepository
import echo.echotest.domain.jobHistory.persistent.JobHistory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class JobHistoryService(
    private val jobHistoryRepository: JobHistoryRepository,
) : CommonService<JobHistory>(jobHistoryRepository) {
    fun findManyByEmployee(employee:Employee, page:Int, size:Int): Page<JobHistory> =
        jobHistoryRepository.findByEmployee(
            employee,
            PageRequest.of(
                page - 1,
                size,
            )
        )

}