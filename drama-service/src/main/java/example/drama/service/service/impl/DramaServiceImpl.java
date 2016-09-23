package example.drama.service.service.impl;

import example.common.entity.Drama;
import example.drama.service.dao.DramaDao;
import example.drama.service.service.DramaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RefreshScope
public class DramaServiceImpl implements DramaService, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(DramaServiceImpl.class);

    private final DramaDao dramaDao;

    @Value("${default-drama-sort-property:id}")
    private String defaultDramaSortProperty;

    @Autowired
    public DramaServiceImpl(DramaDao dramaDao) {
        this.dramaDao = dramaDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(defaultDramaSortProperty, "'defaultDramaSortProperty' must be set.");
        LOGGER.debug("defaultDramaSortProperty={}", this.defaultDramaSortProperty);
    }

    @Override
    public List<Drama> findAllDramas() {
        return dramaDao.findAll(new Sort(Sort.Direction.ASC, defaultDramaSortProperty));
    }

}
