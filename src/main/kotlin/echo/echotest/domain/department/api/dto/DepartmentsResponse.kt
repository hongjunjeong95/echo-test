package echo.echotest.domain.jobHistory.api.dto

import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.employee.persistent.Employee
import echo.echotest.domain.job.persistent.Job
import echo.echotest.domain.location.persistent.Location
import org.springframework.data.domain.Page
import java.util.*


data class DepartmentsResponse(
    val items: Page<DepartmentResponse>
) {
    companion object {
        fun of(jobHistories: Page<Department>) = DepartmentsResponse(jobHistories.map(DepartmentResponse::of))
    }
}

data class DepartmentResponse(
    val departmentId: Long,
    val departmentName: String,
    val managerId: Long,
    val location: Location?,
){
    companion object {
        fun of(department: Department): DepartmentResponse {
            checkNotNull(department.departmentId)
            return DepartmentResponse(
                departmentId = department.departmentId,
                departmentName = department.departmentName,
                managerId = department.manager!!.employeeId,
                location = Location(
                    locationId = department.location!!.locationId,
                    streetAddress = department.location!!.streetAddress,
                    postalCode = department.location!!.postalCode,
                    city = department.location!!.city,
                    stateProvince = department.location!!.stateProvince,
                )
            )
        } }
}