package glassgate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class RulesController {
    @GetMapping("/rules")
    public String rules(Map<String, Object> model){ return "rules"; }
}
