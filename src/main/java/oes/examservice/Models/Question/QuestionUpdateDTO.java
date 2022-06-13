package oes.examservice.Models.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oes.examservice.Entities.Enums.QuestionType;

@Data @AllArgsConstructor @NoArgsConstructor
public class QuestionUpdateDTO {
    private String Question;
    private String Description;
    private String[] Choices;
    private QuestionType QtType;
    private double score;
}
