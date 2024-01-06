package echo.echotest.domain.employee.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.job.persistent.Job
import echo.echotest.domain.jobHistory.persistent.JobHistory
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "employees")
class Employee(
    @Id
    @Column(name = "employee_id", nullable = false, unique = true, updatable = false)
    val employeeId: Long = 0,

    @Column(name = "first_name", length = 20)
    var firstName: String? = null,

    @Column(name = "last_name", length = 25, nullable = false)
    var lastName: String = "",

    @Column(name = "email", length = 25, nullable = false)
    var email: String = "",

    @Column(name = "phone_number", length = 20)
    var phoneNumber: String? = null,

    @Column(name = "hire_date", nullable = false)
    var hireDate: Date = Date(),

    @Column(name = "salary", precision = 8, scale = 2, nullable = false)
    var salary: BigDecimal = BigDecimal.ZERO,

    @Column(name = "commission_pct", precision = 2, scale = 2)
    var commissionPct: BigDecimal? = null,

    @OneToMany(mappedBy = "employee")
    val jobHistories:  List<JobHistory> = emptyList(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    var manager: Employee? = null,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "job_id")
    val job: Job? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    var department: Department? = null,

    @OneToMany(mappedBy = "manager")
    val departments:  List<Department> = emptyList(),
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

    fun update(param: UpdateEmployee){
        this.salary = param.salary ?: this.salary
        this.firstName = param.firstName ?: this.firstName
        this.lastName = param.lastName ?: this.lastName
        this.email = param.email ?: this.email
        this.phoneNumber = param.phoneNumber ?: this.phoneNumber
    }
}

data class UpdateEmployee(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val salary: BigDecimal? = null
)