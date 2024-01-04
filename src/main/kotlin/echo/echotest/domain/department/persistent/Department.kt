package echo.echotest.domain.department.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.jobHistory.persistent.JobHistory
import echo.echotest.domain.location.persistent.Location
import jakarta.persistence.*

@Entity
@Table(name = "locations")
class Department(
    @Id
    @Column(name = "department_id")
    var departmentId: Long = 0,

    @Column(name = "department_name")
    var departmentName: String,

    @Column(name = "manager_id")
    var managerId: Long = 0,

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    val manager: Employee,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "location_id")
    val location: Location,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val jobHistoryList:  List<JobHistory> = emptyList(),
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Department::departmentId)
        private val toStringProperties = arrayOf(
            Department::departmentId
        )
    }
}