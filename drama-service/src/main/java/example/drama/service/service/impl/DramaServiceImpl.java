package example.drama.service.service.impl;

import example.common.entity.Drama;
import example.drama.service.dao.DramaDao;
import example.drama.service.service.DramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DramaServiceImpl implements DramaService {

    private final DramaDao dramaDao;

    @Autowired
    public DramaServiceImpl(DramaDao dramaDao) {
        this.dramaDao = dramaDao;
    }

    @Override
    public List<Drama> findAllDramas() {
        return dramaDao.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

}
