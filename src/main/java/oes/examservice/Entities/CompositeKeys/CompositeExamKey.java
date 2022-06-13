package oes.examservice.Entities.CompositeKeys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class CompositeExamKey implements Serializable {
    private String idStudent;
    private String idExam;
}
