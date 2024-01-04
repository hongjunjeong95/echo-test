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
    @Column(name = "job_id")
    var jobId: String,

    @Column(name = "job_title")
    var jobTitle: String,

    @Column(name = "min_salary", nullable = true)
    var minSalary: Long = 0,

    @Column(name = "max_salary", nullable = true)
    var maxSalary: Long = 0,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val jobHistoryList:  List<JobHistory> = emptyList(),

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val employeeList:  List<Employee> = emptyList(),
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