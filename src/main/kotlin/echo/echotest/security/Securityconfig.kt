package echo.echotest.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity(debug = true)
@EnableMethodSecurity(securedEnabled = true)
@Configuration
class SecurityConfig(
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
         http
            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }
        return http.build()
    }
}