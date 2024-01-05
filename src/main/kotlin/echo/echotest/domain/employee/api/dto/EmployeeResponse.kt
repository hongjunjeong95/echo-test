package echo.echotest.domain.employee.api.dto

import echo.echotest.domain.employee.persistent.Employee
import java.math.BigDecimal
import java.util.Date


data class EmployeeResponse(
    val employeeId: Long,
    val firstName: String?,
    val lastName: String,
    val email: String,
    val phoneNumber: String?,
    val hireDate: Date,
    val salary: BigDecimal,
    val commissionPct: BigDecimal?,
){
    companion object {
        fun of(employee: Employee): EmployeeResponse {
            checkNotNull(employee.employeeId)
            return EmployeeResponse(
                employeeId = employee.employeeId,
                firstName = employee.firstName,
                lastName= employee.lastName,
                email= employee.email,
                phoneNumber= employee.phoneNumber,
                hireDate= employee.hireDate,
                salary= employee.salary,
                commissionPct= employee.commissionPct,
            )
        }
    }
}