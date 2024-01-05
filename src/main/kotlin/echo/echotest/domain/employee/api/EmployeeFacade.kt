package echo.echotest.domain.employee.api

import echo.echotest.domain.department.api.service.DepartmentService
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.employee.service.EmployeeService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmployeeFacade(
    private val employeeService: EmployeeService,
    private val departmentService: DepartmentService,
) {
    @Transactional
    fun findEmployee(id:Long): Employee = employeeService.findByIdOrThrow(id)

    @Transactional
    fun increaseSalaryPercent(departmentId: Long, salaryPercent: Int): Unit{
        val department = departmentService.findByIdOrThrow(departmentId)
        employeeService.findManyByDepartmentId(department).let {employees ->
            employees.filter { this.isAvailableIncreasingSalary(
                it.job!!.maxSalary!!.intValueExact(),
                it.salary.intValueExact(),
                salaryPercent
            )}.map {
                it.update(this.getIncreasedSalary(it.salary.intValueExact(),salaryPercent).toBigDecimal())
                employeeService.save(it)
            }
        }
    }

    private fun isAvailableIncreasingSalary(maxSalary:Int,
                                            currentSalary: Int,
                                            salaryPercent: Int) =
        maxSalary >= this.getIncreasedSalary(currentSalary,salaryPercent)
    private fun getIncreasedSalary(currentSalary: Int, salaryPercent: Int): Int =
        currentSalary * (salaryPercent+100) / 100
}