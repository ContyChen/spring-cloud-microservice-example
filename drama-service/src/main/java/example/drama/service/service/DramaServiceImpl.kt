package example.drama.service.service

import example.common.entity.Drama
import example.drama.service.dao.DramaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class DramaServiceImpl @Autowired constructor(val dramaRepository: DramaRepository) : DramaService {

    override fun findAllDramas(): List<Drama> = dramaRepository.findAll()

}
