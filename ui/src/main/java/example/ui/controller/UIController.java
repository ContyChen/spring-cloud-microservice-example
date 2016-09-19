package example.ui.controller;

import example.ui.cli.ComputeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UIController {

    @Autowired
    private ComputeServiceClient client;

    @GetMapping(path = "/ui")
    public String ui(
            @RequestParam(value = "left", required = false, defaultValue = "100") Integer left,
            @RequestParam(value = "right", required = false, defaultValue = "11") Integer right,
            ModelMap modelMap) {

        modelMap.put("add", client.add(left, right));
        modelMap.put("minus", client.minus(left, right));
        modelMap.put("time", client.time(left, right));
        modelMap.put("div", client.div(left, right));
        modelMap.put("mod", client.mod(left, right));
        modelMap.put("left", left);
        modelMap.put("right", right);
        return "ui";
    }

}
