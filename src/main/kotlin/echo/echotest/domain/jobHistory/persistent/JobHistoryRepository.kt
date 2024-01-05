package echo.echotest.domain.jobHistory.persistent

import echo.echotest.domain.employee.persistent.Employee
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface JobHistoryRepository : JpaRepository<JobHistory, Long> {
    fun findByEmployee(employee: Employee, pageable: Pageable): Page<JobHistory>
}