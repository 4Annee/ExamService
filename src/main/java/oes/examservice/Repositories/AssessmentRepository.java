package oes.examservice.Repositories;

import oes.examservice.Entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentRepository extends JpaRepository<Assessment, String> {
    List<Assessment> getAssessmentsByModuleIdIn(String[] moduleids);
}