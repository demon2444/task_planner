package pl.coderslab.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootproject.model.Plan;
import pl.coderslab.springbootproject.model.TimeCount;
import pl.coderslab.springbootproject.repository.PlanRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;





@Service
@Transactional
public class PlanService {

    private static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("dd-MM-yyyy");
    private static final SimpleDateFormat SDF_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm:ss");

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

    public List<Plan> findByImportantAndUrgent(boolean important, boolean urgent, Long id) {
        return planRepository.findAllByImportantAndUrgent(important, urgent,  id);
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
        Date stop = setDateLimit(timeStart);
        return planRepository.findAllByTimeStartAndId(timeStart,stop, id);
    }

    public Date setDateLimit(Date timeStart) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeStart);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public TimeCount countTime(Date dateStop) {

    List<TimeCount> timeCounts = new ArrayList<>();

// Custom date format

        Date d1 = new Date();
        Date d2 = dateStop;
        /*try {

            d2 = SDF_DATE_TIME.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

// Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        long diffdays = diff / (60 * 60 * 1000 * 24);

        TimeCount timeCount = new TimeCount(diffdays, diffHours, diffMinutes, diffSeconds);

        if(diffSeconds < 0) {
            timeCount.setDays(0l);
            timeCount.setHours(0l);
            timeCount.setMinutes(0l);
            timeCount.setSeconds(0l);
        }




    return timeCount;


    }



}
