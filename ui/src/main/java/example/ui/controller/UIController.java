package example.ui.controller;

import example.ui.cli.ComputeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UIController {

    @Autowired
    private ComputeServiceClient client;

    @GetMapping(path = "ui")
    public Object ui(
            @RequestParam(value = "left", required = false, defaultValue = "100") Integer left,
            @RequestParam(value = "right", required = false, defaultValue = "11") Integer right) {

        Map<String, Object> map = new HashMap<>();
        map.put("add", client.add(left, right));
        map.put("minus", client.minus(left, right));
        map.put("time", client.time(left, right));
        map.put("div", client.div(left, right));
        map.put("mod", client.mod(left, right));
        return map;
    }

}
