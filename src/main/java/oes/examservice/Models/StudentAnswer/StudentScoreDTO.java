package oes.examservice.Models.StudentAnswer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentScoreDTO {
    private String idStudent;
    private String idExam;
    private String idQt;
    private boolean isCorrectAnswer;
    private double score;
}
