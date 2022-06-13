package oes.examservice.Repositories;

import oes.examservice.Entities.CompositeKeys.CompositeAnswerKey;
import oes.examservice.Entities.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, CompositeAnswerKey> {
    @Query("select s from StudentAnswer s where s.id.idStudent = :idStudent and s.id.idExam = :idExam ")
    List<StudentAnswer> getStudentAnswers(String idStudent, String idExam);
}