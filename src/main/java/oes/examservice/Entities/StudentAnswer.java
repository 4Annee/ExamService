package oes.examservice.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oes.examservice.Entities.CompositeKeys.CompositeAnswerKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class StudentAnswer {
    @EmbeddedId
    private CompositeAnswerKey id;
    private String Answer;
    private double score;
}
