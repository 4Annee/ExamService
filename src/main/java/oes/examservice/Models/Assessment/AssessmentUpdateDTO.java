package oes.examservice.Models.Assessment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AssessmentUpdateDTO {
    private String AssessmentTitle;
    private Date startTime;
    private Date endTime;
}
