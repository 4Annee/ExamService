package oes.examservice.Models.Assessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AssessmentDTO {
    private String assessmentId;
    private String assessmentTitle;
    private String moduleId;
    private Date startTime;
    private Date endTime;
}
