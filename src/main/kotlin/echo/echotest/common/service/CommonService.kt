package echo.echotest.common.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository

open class CommonService<T>(
    private val repository: JpaRepository<T, Long>
) {
}