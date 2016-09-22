package example.drama.service.dao;

import example.common.entity.Drama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DramaDao extends JpaRepository<Drama, String>, DramaCustomerDao {
}
