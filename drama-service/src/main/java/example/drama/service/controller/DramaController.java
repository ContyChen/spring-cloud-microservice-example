package example.drama.service.controller;

import example.common.entity.Drama;
import example.drama.service.service.DramaService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dramas")
public class DramaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DramaController.class);

    @Autowired
    private DramaService dramaService;

    @GetMapping
    public Object findAll() {
        List<Drama> list = dramaService.findAllDramas();
        list.forEach(drama -> LOGGER.debug("{}", ReflectionToStringBuilder.toString(drama, ToStringStyle.SIMPLE_STYLE)));
        return list;
    }

}
