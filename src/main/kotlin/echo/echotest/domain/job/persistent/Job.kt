package echo.echotest.domain.job.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.jobHistory.persistent.JobHistory
import jakarta.persistence.*

@Entity
@Table(name = "jobs")
class Job(
    @Id
    @Column(name = "job_id", length = 10, nullable = false, unique = true, updatable = false)
    val jobId: String = "",

    @Column(name = "job_title", length = 35, nullable = false)
    var jobTitle: String = "",

    @Column(name = "min_salary", precision = 8, scale = 0)
    var minSalary: Long? = null,

    @Column(name = "max_salary", precision = 8, scale = 0)
    var maxSalary: Long? = null,

    @OneToMany(mappedBy = "job")
    val jobHistories:  List<JobHistory> = emptyList(),

    @OneToMany(mappedBy = "job")
    val employees:  List<Employee> = emptyList(),
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Job::jobId)
        private val toStringProperties = arrayOf(
            Job::jobId
        )
    }
}