package echo.echotest.domain.department.api

import echo.echotest.domain.department.api.service.DepartmentService
import echo.echotest.domain.department.persistent.Department
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DepartmentFacade(
    private val departmentService: DepartmentService,
) {
    @Transactional
    fun findDepartment(id:Long): Department = departmentService.findByIdOrThrow(id)
}