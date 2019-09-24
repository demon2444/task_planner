package pl.coderslab.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.springbootproject.model.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findAllByUserId(Long id);
    List<Plan> findAllByImportantAndUrgent(boolean important, boolean urgent);
    List<Plan> findAllByNameContainingIgnoreCase(String name);



}
