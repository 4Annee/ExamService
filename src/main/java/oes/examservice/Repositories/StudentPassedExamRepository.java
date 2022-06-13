package oes.examservice.Repositories;


import oes.examservice.Entities.CompositeKeys.CompositeExamKey;
import oes.examservice.Entities.StudentPassedExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPassedExamRepository extends JpaRepository<StudentPassedExam, CompositeExamKey> {
}