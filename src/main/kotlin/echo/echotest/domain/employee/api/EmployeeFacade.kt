package echo.echotest.domain.employee.api

import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.employee.service.EmployeeService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeFacade(
    private val employeeService: EmployeeService,
) {
    @Transactional
    fun findOne(id:Long): Employee = employeeService.findByIdOrThrow(id)
}