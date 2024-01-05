package echo.echotest.domain.jobHistory.api.dto

import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.job.persistent.Job
import echo.echotest.domain.jobHistory.persistent.JobHistory
import echo.echotest.domain.jobHistory.persistent.JobHistoryId
import org.springframework.data.domain.Page
import java.util.*


data class JobHistoriesResponse(
    val items: Page<JobHistoryResponse>
) {
    companion object {
        fun of(jobHistories: Page<JobHistory>) = JobHistoriesResponse(jobHistories.map(JobHistoryResponse::of))
    }
}

data class JobHistoryResponse(
    val id: JobHistoryId,
    val endDate: Date,
    val job: Job?,
    val department: Department?,
){
    companion object {
        fun of(jobHistory: JobHistory): JobHistoryResponse {
            checkNotNull(jobHistory.id)
            return JobHistoryResponse(
                id = jobHistory.id,
                endDate = jobHistory.endDate,
                job = Job(
                    jobId = jobHistory.job!!.jobId,
                    jobTitle = jobHistory.job!!.jobTitle,
                    minSalary = jobHistory.job!!.minSalary,
                    maxSalary = jobHistory.job!!.maxSalary,
                ),
                department = Department(
                    departmentId = jobHistory.department!!.departmentId,
                    departmentName = jobHistory.department!!.departmentName
                )
            )
        } }
}