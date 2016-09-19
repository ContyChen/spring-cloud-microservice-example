package example.ui.cli;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "API-GATEWAY", path = "/compute-service", fallback = ComputeServiceCircuitBreaker.class)
public interface ComputeServiceClient {

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam("left") Integer left, @RequestParam("right") Integer right);

    @RequestMapping(path = "/minus", method = RequestMethod.GET)
    public Integer minus(@RequestParam("left") Integer left, @RequestParam("right") Integer right);

    @RequestMapping(path = "/time", method = RequestMethod.GET)
    public Integer time(@RequestParam("left") Integer left, @RequestParam("right") Integer right);

    @RequestMapping(path = "/div", method = RequestMethod.GET)
    public Integer div(@RequestParam("left") Integer left, @RequestParam("right") Integer right);

    @RequestMapping(path = "/mod", method = RequestMethod.GET)
    public Integer mod(@RequestParam("left") Integer left, @RequestParam("right") Integer right);

}
