package example.compute.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ComputeController {

    @GetMapping("/add")
    public int add(int left, int right) {
        return left + right;
    }

    @GetMapping("/minus")
    public int minus(int left, int right) {
        return left - right;
    }

    @GetMapping("/time")
    public int time(int left, int right) {
        return left * right;
    }

    @GetMapping("/div")
    public int div(int left, int right) {
        return left / right;
    }

    @GetMapping("/mod")
    public int mod(int left, int right) {
        return left % right;
    }

}
