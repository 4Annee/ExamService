package oes.examservice.Models.StudentAnswer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentPassedExamDTO {
    private String idstudent;
    private String idExam;
}
