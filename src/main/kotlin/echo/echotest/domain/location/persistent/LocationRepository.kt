package echo.echotest.domain.country.persistent

import echo.echotest.domain.jobHistory.persistent.JobHistory
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<JobHistory, Long> {
}