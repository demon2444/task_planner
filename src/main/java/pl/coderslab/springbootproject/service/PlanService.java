package pl.coderslab.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootproject.model.Plan;
import pl.coderslab.springbootproject.repository.PlanRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class PlanService {

    private static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("dd-MM-yyyy");
    private static final SimpleDateFormat SDF_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH-mm-ss");

    private PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> showPlans(Long userId) {
        List<Plan> allByUserId = planRepository.findAllByUserId(userId);
        spitDateTime(allByUserId);
        return allByUserId;
    }

    public void spitDateTime(List<Plan> plans) {
        for (Plan p : plans) {
            if(p.getTimeStart() == null || p.getTimeStop() == null) {
                p.setTimeStart(new Date());
                p.setTimeStop(new Date());
            }



            p.setDateStartView(getDate(p.getTimeStart()));
            p.setTimeStartView(getTime(p.getTimeStart()));
            p.setDateStopView(getDate(p.getTimeStop()));
            p.setTimeStopView(getTime(p.getTimeStop()));

        }
    }


    public String getTime(Date time) {
        return SDF_TIME.format(time);
    }

    public String getDate(Date time) {
        return SDF_DATE.format(time);
    }

    public void savePlan(Plan plan) {
        planRepository.save(plan);
    }

    public List<Plan> findByImportantAndUrgent(boolean important, boolean urgent) {
        return planRepository.findAllByImportantAndUrgent(important, urgent);
    }

    public Date setDate(String date, String time) {
        Date dateTime = new Date();
        try {
            dateTime = SDF_DATE_TIME.parse(date + " " + time);
        } catch (ParseException ex) {

        }
        return dateTime;
    }



    public Date setDateTosave(String date, String time) {
        Date dateTime = new Date();
        try {
            dateTime = SDF_DATE_TIME.parse(date + " " + time);
        } catch (ParseException ex) {

        }
        return dateTime;
    }


    public Date setDateFrom(String dateForm) {
        Date dateTime = new Date();
        try {
            dateTime = SDF_DATE_TIME.parse(dateForm);
        } catch (ParseException ex) {

        }
        return dateTime;
    }


    public List<Plan> findByName(String name) {
        List<Plan> planSearch = planRepository.findAllByNameContainingIgnoreCase(name);
        if(planSearch==null){
            return new ArrayList<>();
        }
        spitDateTime(planSearch);
        return planSearch;
    }
    public Plan findById(Long id) {
        return planRepository.findFirstById(id);
    }

    public List<Plan> findyByDay(Date timeStart, Long id) {
        return planRepository.findAllByTimeStartAndId(timeStart, id);
    }


}
