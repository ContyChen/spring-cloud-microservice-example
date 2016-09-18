package example.compute.service.controller;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ComputeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComputeController.class);

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

    // 接口有100%的可能性会抛出异常
    private void randomRuntimeException() {
        if (RandomUtils.nextInt(0, 99) == 1) {
            throw new BussinessException();
        }
    }

    public static final class BussinessException extends RuntimeException {
        public BussinessException() {
            super();
        }
    }

}
