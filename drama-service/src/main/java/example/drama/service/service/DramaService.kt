package example.drama.service.service

import example.common.entity.Drama
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface DramaService {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findAllDramas(): List<Drama>

}
