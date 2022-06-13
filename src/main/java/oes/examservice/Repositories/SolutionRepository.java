package oes.examservice.Repositories;

import oes.examservice.Entities.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Solution getSolutionByQtId(String qtid);
}