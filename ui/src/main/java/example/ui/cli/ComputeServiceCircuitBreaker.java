package example.ui.cli;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComputeServiceCircuitBreaker implements ComputeServiceClient {

    private static Integer DEFAULT_RESULT = Integer.MIN_VALUE;

    @Override
    public Integer add(@RequestParam("left") Integer left, @RequestParam("right") Integer right) {
        return DEFAULT_RESULT;
    }

    @Override
    public Integer minus(@RequestParam("left") Integer left, @RequestParam("right") Integer right) {
        return DEFAULT_RESULT;
    }

    @Override
    public Integer time(@RequestParam("left") Integer left, @RequestParam("right") Integer right) {
        return DEFAULT_RESULT;
    }

    @Override
    public Integer div(@RequestParam("left") Integer left, @RequestParam("right") Integer right) {
        return DEFAULT_RESULT;
    }

    @Override
    public Integer mod(@RequestParam("left") Integer left, @RequestParam("right") Integer right) {
        return DEFAULT_RESULT;
    }

}
