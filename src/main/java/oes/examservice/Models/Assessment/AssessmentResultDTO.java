package oes.examservice.Models.Assessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AssessmentResultDTO {
    private String AssessmentTitle;
    private Date passingDate;
    private double finalScore;
    private boolean Corrected;
}
