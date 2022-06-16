package oes.examservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oes.examservice.Entities.CompositeKeys.CompositeExamKey;

import javax.persistence.*;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class StudentPassedExam {
    @EmbeddedId
    private CompositeExamKey id;
    private double finalscore;
    private boolean corrected;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private Collection<StudentAnswer> answers;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Assessment assessment;
}
