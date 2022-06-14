package oes.examservice.Models.Assessment;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AssessmentCreationDTO {
    private String moduleId;
    private String AssessmentTitle;
    private Date startTime;
    private Date endTime;
}
