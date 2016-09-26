package example.drama.service.controller

import example.drama.service.service.DramaService
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dramas")
open class DramaController @Autowired constructor(val dramaService: DramaService) {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(DramaController::class.java)
    }

    @GetMapping
    fun findAllDrama(): Any {
        val dramas = dramaService.findAllDramas()
        dramas.forEach { LOGGER.debug("{}", ReflectionToStringBuilder.toString(it, ToStringStyle.SIMPLE_STYLE)) }
        return dramas
    }

}
