package example.compute.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ComputeController {

    @GetMapping("/add")
    public int add(@RequestParam("left") int left, @RequestParam("right") int right) {
        return left + right;
    }

    @GetMapping("/minus")
    public int minus(@RequestParam("left") int left, @RequestParam("right") int right) {
        return left - right;
    }

    @GetMapping("/time")
    public int time(@RequestParam("left") int left, @RequestParam("right") int right) {
        return left * right;
    }

    @GetMapping("/div")
    public int div(@RequestParam("left") int left, @RequestParam("right") int right) {
        return left / right;
    }

    @GetMapping("/mod")
    public int mod(@RequestParam("left") int left, @RequestParam("right") int right) {
        return left % right;
    }

}
