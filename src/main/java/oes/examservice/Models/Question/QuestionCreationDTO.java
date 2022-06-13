package oes.examservice.Models.Question;

import oes.examservice.Entities.Enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class QuestionCreationDTO {
    private String idExam;
    private String Question;
    private QuestionType qtType;
    private String Description;
    private double score;
    private String[] choices;
}
