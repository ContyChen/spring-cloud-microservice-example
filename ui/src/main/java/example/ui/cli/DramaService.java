package example.ui.cli;

import example.common.entity.Drama;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "API-GATEWAY", path = "/drama-service", fallback = DramaServiceCircuitBreaker.class)
public interface DramaService {

    @RequestMapping(path = "/dramas", method = RequestMethod.GET)
    public List<Drama> findAllDramas();

}
