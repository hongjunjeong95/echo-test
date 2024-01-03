package echo.echotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EchoTestApplication

fun main(args: Array<String>) {
    runApplication<EchoTestApplication>(*args)
}
