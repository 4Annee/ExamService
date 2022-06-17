package oes.examservice.Repositories;

import oes.examservice.Entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssessmentRepository extends JpaRepository<Assessment, String> {
    @Query("select a from Assessment a where a.moduleId  = :moduleid and a.starttime > current_timestamp ")
    List<Assessment> getUpcomingAssessments(String moduleid);

    List<Assessment> getAssessmentsByModuleId(String moduleId);
}