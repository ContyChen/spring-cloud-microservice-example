package example.drama.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
open class ApplicationBoot

fun main(args: Array<String>) {
    SpringApplicationBuilder(ApplicationBoot::class.java).web(true).run(*args)
}
