package oes.examservice.Repositories;

import oes.examservice.Entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, String> {
}