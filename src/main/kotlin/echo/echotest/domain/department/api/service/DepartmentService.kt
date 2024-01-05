package echo.echotest.domain.department.api.service

import echo.echotest.common.persistent.findByIdOrThrow
import echo.echotest.common.service.CommonService
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.department.persistent.DepartmentRepository
import org.springframework.stereotype.Service

@Service
class DepartmentService(
    private val departmentRepository: DepartmentRepository,
) : CommonService<Department>(departmentRepository) {
    fun findByIdOrThrow(id: Long): Department = departmentRepository.findByIdOrThrow(id, "존재하지 않는 회원입니다.")
}