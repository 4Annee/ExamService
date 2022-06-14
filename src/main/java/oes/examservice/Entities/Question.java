package oes.examservice.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oes.examservice.Entities.Enums.QuestionType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String Question;
    private QuestionType qtType;
    private String Description;
    private double score;
    @ElementCollection
    List<String> Choices;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinTable(name = "question_solution",
            joinColumns = @JoinColumn(name = "question_null"),
            inverseJoinColumns = @JoinColumn(name = "solution_id"))
    private Solution solution;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;
}
