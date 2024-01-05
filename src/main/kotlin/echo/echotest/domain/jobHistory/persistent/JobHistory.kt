package echo.echotest.domain.jobHistory.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.job.persistent.Job
import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "job_history")
class JobHistory(
    @EmbeddedId
    val id: JobHistoryId = JobHistoryId(),

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id", nullable = false)
    var employee: Employee? = null,

    @Column(name = "end_date", nullable = false)
    var endDate: Date = Date(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    var job: Job? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    var department: Department? = null
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(JobHistory::id)
        private val toStringProperties = arrayOf(
            JobHistory::id
        )
    }
}

@Embeddable
data class JobHistoryId(
    @Column(name = "employee_id", nullable = false)
    val employeeId: Long? = null,

    @Column(name = "start_date", nullable = false)
    val startDate: Date? = null
):Serializable