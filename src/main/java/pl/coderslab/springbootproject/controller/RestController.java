package pl.coderslab.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springbootproject.model.TimeCount;
import pl.coderslab.springbootproject.service.PlanService;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class RestController {

    private PlanService planService;

    @Autowired
    public RestController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/time")
    public List<TimeCount> timer() {

       // List<TimeCount> timeCounts = planService.countTime();
        return null;
    }

}
