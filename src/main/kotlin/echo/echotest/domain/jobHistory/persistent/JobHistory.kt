package echo.echotest.domain.jobHistory.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.country.persistent.Country
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.job.persistent.Job
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "job_histories")
class JobHistory(
    @Id
    @Column(name = "job_history_id")
    val employeeId: Long = 0,

    @Column(name = "start_date")
    var startDate: LocalDateTime,

    @Column(name = "end_date")
    var endDate: LocalDateTime,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "job_id")
    val job: Job,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "department_id")
    val department: Department,
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(JobHistory::employeeId)
        private val toStringProperties = arrayOf(
            JobHistory::employeeId
        )
    }
}