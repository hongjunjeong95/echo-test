package echo.echotest.domain.employee.service

import echo.echotest.common.persistent.findByIdOrThrow
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.employee.persistent.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
) {
    fun findByIdOrThrow(id: Long): Employee = employeeRepository.findByIdOrThrow(id, "존재하지 않는 회원입니다.")
    fun findManyByDepartmentId(department: Department): List<Employee> = employeeRepository.findByDepartment(department)
    fun save(param: Employee) =
        employeeRepository.save(param)
}