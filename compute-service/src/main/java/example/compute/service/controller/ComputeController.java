package example.compute.service.controller;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RefreshScope
@RequestMapping("/")
public class ComputeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComputeController.class);

    @Value("${fail-rate:1}")
    private Integer failRate;

    @PostConstruct
    private void init() {
        LOGGER.info("failRate: {}", failRate);
    }

    @GetMapping("fail-rate")
    public Integer failRate() {
        return failRate;
    }

    @GetMapping("/add")
    public int add(@RequestParam("left") int left, @RequestParam("right") int right) {
        randomRuntimeException();
        int result = left + right;
        LOGGER.info("result: {}", result);
        return result;
    }

    @GetMapping("/minus")
    public int minus(@RequestParam("left") int left, @RequestParam("right") int right) {
        randomRuntimeException();
        int result = left - right;
        LOGGER.info("result: {}", result);
        return result;
    }

    @GetMapping("/time")
    public int time(@RequestParam("left") int left, @RequestParam("right") int right) {
        randomRuntimeException();
        int result = left * right;
        LOGGER.info("result: {}", result);
        return result;
    }

    @GetMapping("/div")
    public int div(@RequestParam("left") int left, @RequestParam("right") int right) {
        randomRuntimeException();
        int result = left / right;
        LOGGER.info("result: {}", result);
        return result;
    }

    @GetMapping("/mod")
    public int mod(@RequestParam("left") int left, @RequestParam("right") int right) {
        randomRuntimeException();
        int result = left % right;
        LOGGER.info("result: {}", result);
        return result;
    }

    private void randomRuntimeException() {
        if (RandomUtils.nextInt(0, 99) <= failRate) {
            throw new BussinessException();
        }
    }

    public static final class BussinessException extends RuntimeException {
        public BussinessException() {
            super();
        }
    }

}
