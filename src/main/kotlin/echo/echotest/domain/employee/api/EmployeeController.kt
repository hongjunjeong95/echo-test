package echo.echotest.domain.employee.api

import echo.echotest.domain.employee.service.EmployeeService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController(private val employeeService: EmployeeService) {
}