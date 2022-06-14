package oes.examservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oes.examservice.Entities.CompositeKeys.CompositeAnswerKey;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class StudentAnswer {
    @EmbeddedId
    private CompositeAnswerKey id;
    private String Answer;
    private double score;
    private boolean correctanswer;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "idStudent", referencedColumnName = "idStudent"),
            @JoinColumn(name = "idExam", referencedColumnName = "idExam")
    })
    private StudentPassedExam passedExam;
}
