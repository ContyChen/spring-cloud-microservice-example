package example.drama.service.dao

import example.common.entity.Drama
import org.springframework.data.jpa.repository.JpaRepository

interface DramaRepository : JpaRepository<Drama, String> {
}
