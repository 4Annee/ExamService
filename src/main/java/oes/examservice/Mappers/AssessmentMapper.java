package oes.examservice.Mappers;

import oes.examservice.Entities.StudentPassedExam;
import oes.examservice.Models.Assessment.AssessmentResultDTO;

import java.util.ArrayList;
import java.util.List;

public class AssessmentMapper {
    public static List<AssessmentResultDTO> getAssessmentForStudent(List<StudentPassedExam> passedExams){
        List<AssessmentResultDTO> result = new ArrayList<>();
        for (StudentPassedExam a :
                passedExams) {
            result.add(new AssessmentResultDTO(a.getAssessment().getAssessmentTitle(),a.getAssessment().getStarttime(),a.getFinalscore(),a.isCorrected()));
        }
        return result;
    }
}
