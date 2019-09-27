package pl.coderslab.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springbootproject.model.Plan;

import java.util.Date;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("select p from Plan p where p.user.id = :id order by p.timeStart")
    List<Plan> findAllByUserId(Long id);

    @Query("select p from Plan p where p.important = :important and p.urgent = :urgent and p.user.id = :id order by p.timeStart")
    List<Plan> findAllByImportantAndUrgent(boolean important, boolean urgent, Long id);

    List<Plan> findAllByNameContainingIgnoreCase(String name);

    Plan findFirstById(Long id);

    @Query("select p from Plan p where p.timeStart >= :timeStart AND  p.timeStart < :timeStop  and p.user.id = :id and p.done = false order by p.timeStart")
    List<Plan> findAllByTimeStartAndId(Date timeStart,Date timeStop, Long id);
}



