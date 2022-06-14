package oes.examservice.Entities.CompositeKeys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class CompositeAnswerKey implements Serializable {
    private String idAnswer;
    private String idStudExam;
    private String idQt;
}
