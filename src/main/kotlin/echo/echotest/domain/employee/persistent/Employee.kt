package echo.echotest.domain.employee.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.job.persistent.Job
import echo.echotest.domain.jobHistory.persistent.JobHistory
import echo.echotest.domain.region.persistent.Region
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "employees")
class Employee(
    @Id
    @Column(name = "employee_id")
    var employeeId: Long = 0,

    @Column(name = "first_name", nullable = true)
    var firstName: String,

    @Column(name = "last_name")
    var lastName: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "phone_number", nullable = true)
    var phoneNumber: Number,

    @Column(name = "hire_date")
    var hireDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "salary")
    var salary: Number,

    @Column(name = "commission_pct", nullable = true)
    var commissionPct: Number,

    @Enumerated(EnumType.STRING)
    val role: UserRole = UserRole.USER,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val departmentList:  List<JobHistory> = emptyList(),

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "job_id")
    val job:Job,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    val manager: Employee,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "department_id")
    val department: Department,
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Employee::employeeId)
        private val toStringProperties = arrayOf(
            Employee::employeeId,
        )
    }
}


enum class UserRole {
    USER, PRODUCER, ADMIN, ANONYMOUS
}