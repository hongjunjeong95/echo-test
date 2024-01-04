package echo.echotest.domain.job.persistent

import echo.echotest.domain.jobHistory.persistent.JobHistory
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository : JpaRepository<JobHistory, Long> {
}