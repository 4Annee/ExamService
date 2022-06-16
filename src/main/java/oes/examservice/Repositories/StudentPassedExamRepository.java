package oes.examservice.Repositories;


import oes.examservice.Entities.CompositeKeys.CompositeExamKey;
import oes.examservice.Entities.StudentPassedExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentPassedExamRepository extends JpaRepository<StudentPassedExam, CompositeExamKey> {
    @Query("select ps from StudentPassedExam ps where ps.id.idStudent = :idstud")
    List<StudentPassedExam> getStudentexams(String idstud);

    @Query("select ps from StudentPassedExam ps where ps.id.idExam = :idexam")
    List<StudentPassedExam> getExamScores(String idexam);
}