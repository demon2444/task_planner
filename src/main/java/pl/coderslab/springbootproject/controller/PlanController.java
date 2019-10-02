package pl.coderslab.springbootproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootproject.model.Plan;
import pl.coderslab.springbootproject.model.User;
import pl.coderslab.springbootproject.service.PlanService;
import pl.coderslab.springbootproject.service.UserService;
import pl.coderslab.springbootproject.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Controller
@RequestMapping("/plan")
public class PlanController {

    private PlanService planService;
    private UserService userService;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public PlanController(PlanService planService, UserService userService, UserServiceImpl userServiceImpl) {
        this.planService = planService;
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping("/show/{id}")
    public String showMyPlan(Model model, @PathVariable Long id) {

        ;

        List<Plan> plans = planService.showPlans(userServiceImpl.getUser().getId());
        model.addAttribute("plans", plans);
        return "plans";
    }


    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("plan", new Plan());
        return "addPlan";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid Plan plan, BindingResult result, Model model) {
        List<ObjectError> err = result.getAllErrors();
        if (result.hasErrors()) {
            System.err.println(err);
            return "addPlan";
        } else {
            plan.setDone(false);
            plan.setTimeStart(planService.setDate(plan.getDateStartView(), plan.getTimeStartView()));
            plan.setTimeStop(planService.setDate(plan.getDateStopView(), plan.getTimeStopView()));


            User user = userServiceImpl.getUser();
            plan.setUser(user);

            planService.savePlan(plan);


            List<Plan> plans = planService.showPlans(user.getId());


            model.addAttribute("plans", plans);


            return "plans";
        }
    }

    @GetMapping("/planMatrix")
    public String planMatrix(Model model) {

        User user = userServiceImpl.getUser();


        List<Plan> importantAndUrgent = planService.findByImportantAndUrgent(true, true, user.getId());
        model.addAttribute("iu", importantAndUrgent);
        List<Plan> importantNotUrgent = planService.findByImportantAndUrgent(true, false, user.getId());
        model.addAttribute("iNu", importantNotUrgent);
        List<Plan> notImportantUrgent = planService.findByImportantAndUrgent(false, true, user.getId());
        model.addAttribute("nIu", notImportantUrgent);
        List<Plan> notImportantNotUrgent = planService.findByImportantAndUrgent(false, false, user.getId());
        model.addAttribute("nInU", notImportantNotUrgent);
        return "planMatrix";
    }

    @GetMapping("/find")
    public String findByName() {
        return "search";
    }

    @GetMapping("/search")
    public String findByName(Model model, @RequestParam(defaultValue = "") String searchKey) {
        if (searchKey.equals("")) {
            return "noPlans";
        }
        List<Plan> resultSearch = planService.findByName(searchKey);
        model.addAttribute("resultSearch", resultSearch);
        return "search";
    }

    @GetMapping("/update/{id}")
    public String updatePlan(@PathVariable Long id, Model model) {
        Plan plan = planService.findById(id);

        plan.setTimeStartView(planService.getTime(plan.getTimeStart()));
        plan.setDateStartView(planService.getDate(plan.getTimeStart()));
        plan.setTimeStopView(planService.getTime(plan.getTimeStop()));
        plan.setDateStopView(planService.getDate(plan.getTimeStop()));

        User user = userServiceImpl.getUser();
        plan.setUser(user);


        model.addAttribute("plan", plan);
        return "addPlan";
    }


    @PostMapping("/update/{id}")
    public String updatePlan(@PathVariable Long id, @ModelAttribute @Valid Plan plan, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addPlan";
        }

        plan.setTimeStart(planService.setDate(plan.getDateStartView(), plan.getTimeStartView()));
        plan.setTimeStop(planService.setDate(plan.getDateStopView(), plan.getTimeStopView()));

        planService.savePlan(plan);

        User user = userServiceImpl.getUser();
        List<Plan> plans = planService.showPlans(user.getId());


        model.addAttribute("plans", plans);


        return "plans";
    }

    @GetMapping("/day")
    public String daySchedule() {
        return "day";
    }


    @GetMapping("/dayF")
    public String dayScheduleFind(Model model, @RequestParam(defaultValue = "") String dayStart, @RequestParam(defaultValue = "") String hourStart) {

        Date timeStart = planService.setDate(dayStart, hourStart);
        String timeSes = dayStart + " " + hourStart;

        User user = userServiceImpl.getUser();
        Long id = user.getId();


        List<Plan> plans = planService.findyByDay(timeStart, id);

        if (plans.isEmpty()) {
            return "noPlans";
        } else {
            List<Long> time = new ArrayList<>();
            for (Plan p: plans) {
                time.add(planService.countTime(p.getTimeStop()));
            }
            model.addAttribute("time", time);


            planService.spitDateTime(plans);
            model.addAttribute("plans", plans);
            model.addAttribute("timeSes", timeSes);
            return "plans";
        }



    }




    @GetMapping("/done/{id}/{timeSes}")
    public String doneTask(Model model, @PathVariable String timeSes, @PathVariable Long id) {
        Plan plan = planService.findById(id);
        plan.setDone(true);
        planService.savePlan(plan);
        Date date = planService.setDateFrom(timeSes);

        User user = userServiceImpl.getUser();

        List<Plan> plans = planService.findyByDay(date, user.getId());
        model.addAttribute("plans", plans);
        return "plans";
    }




}
