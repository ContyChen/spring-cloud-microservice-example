package example.ui.controller;

import example.common.entity.Drama;
import example.ui.cli.DramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UIController {

    @Autowired
    private DramaService dramaService;

    @GetMapping(path = "/ui")
    public String ui(ModelMap modelMap) {
        final List<Drama> dramas = dramaService.findAllDramas();
        modelMap.put("dramas", dramas);
        return "ui";
    }

}
