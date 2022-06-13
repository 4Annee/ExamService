package oes.examservice.Models.Solution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oes.examservice.Entities.Question;

@Data @AllArgsConstructor @NoArgsConstructor
public class SolutionCreationDTO {
    private String qtid;
    private String Answer;
}
