package echo.echotest.domain.employee.persistent

import echo.echotest.domain.department.persistent.Department
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {
    fun findByDepartment(department: Department):List<Employee>
}