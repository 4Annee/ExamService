package oes.examservice.Entities.CompositeKeys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class CompositeAnswerKey implements Serializable {
    private String idStudent;
    private String idExam;
    private String idQt;
}
