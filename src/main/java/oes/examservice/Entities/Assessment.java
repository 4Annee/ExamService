package oes.examservice.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Assessment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String assessmentTitle;
    private String moduleId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    private boolean published;
    @OneToMany(mappedBy = "assessment",cascade = CascadeType.REMOVE)
    private Collection<Question> questions;
    @JsonIgnore
    @OneToMany(mappedBy = "assessment")
    private Collection<StudentPassedExam> passedExams;
}