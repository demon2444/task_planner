package pl.coderslab.springbootproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootproject.model.Plan;
import pl.coderslab.springbootproject.service.PlanService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }




    @GetMapping("/show/{id}")
    public String showMyPlan(Model model, @PathVariable Long id) {
        List<Plan> plans = planService.showPlans(id);
        model.addAttribute("plans", plans);
        return "plans";
    }


    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("plan", new Plan());
        return "addPlan";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid Plan plan, BindingResult result) {
        List<ObjectError> err = result.getAllErrors();
        if (result.hasErrors()) {
            System.err.println(err);
            return "addPlan";
        }else {
            plan.setDone(false);
            plan.setTimeStart(planService.setDate(plan.getDateStartView(), plan.getTimeStartView()));
            plan.setTimeStop(planService.setDate(plan.getDateStopView(), plan.getTimeStopView()));

            planService.savePlan(plan);
            return "plans";
        }
    }

    @GetMapping("/planMatrix")
    public String planMatrix(Model model) {
        List<Plan> importantAndUrgent = planService.findByImportantAndUrgent(true, true);
        model.addAttribute("iu", importantAndUrgent);
        List<Plan> importantNotUrgent = planService.findByImportantAndUrgent(true, false);
        model.addAttribute("iNu", importantNotUrgent);
        List<Plan> notImportantUrgent = planService.findByImportantAndUrgent(false, true);
        model.addAttribute("nIu", notImportantUrgent);
        List<Plan> notImportantNotUrgent = planService.findByImportantAndUrgent(false, false);
        model.addAttribute("nInU", notImportantNotUrgent);
        return "planMatrix";
    }
    @GetMapping("/find")
    public String findByName() {
        return "search";
    }

    @PostMapping("/find")
    public String findByName(Model model, @PathVariable String searchKey) {
        System.out.println(searchKey);
        List<Plan> resultSearch = planService.findByName(searchKey);
        model.addAttribute("resultSearch", resultSearch);
        return "search";
    }

}
