package oes.examservice.Controllers;

import oes.examservice.Entities.*;
import oes.examservice.Entities.CompositeKeys.CompositeExamKey;
import oes.examservice.Mappers.AssessmentMapper;
import oes.examservice.Models.Assessment.AssessmentCreationDTO;
import oes.examservice.Models.Assessment.AssessmentDTO;
import oes.examservice.Models.Assessment.AssessmentResultDTO;
import oes.examservice.Models.Assessment.AssessmentUpdateDTO;
import oes.examservice.Models.Question.QuestionCreationDTO;
import oes.examservice.Models.Question.QuestionUpdateDTO;
import oes.examservice.Models.Solution.SolutionCreationDTO;
import oes.examservice.Models.Solution.SolutionUpdateDTO;
import oes.examservice.Repositories.AssessmentRepository;
import oes.examservice.Repositories.QuestionRepository;
import oes.examservice.Repositories.SolutionRepository;
import oes.examservice.Repositories.StudentPassedExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/Exam")
public class ExamController {
    @Autowired
    AssessmentRepository assessmentRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    SolutionRepository solutionRepository;
    @Autowired
    StudentPassedExamRepository passedExamRepository;


    @GetMapping("/Score/")
    public double getStudentScore(@RequestBody CompositeExamKey key){
        StudentPassedExam ps = passedExamRepository.findById(new CompositeExamKey(key.getIdStudent(), key.getIdExam())).get();
        return ps.getFinalscore();
    }

    @GetMapping("/Score/{idexam}")
    public List<StudentPassedExam> getStudentsScore(@PathVariable String idexam){
        return passedExamRepository.getExamScores(idexam);
    }

    @GetMapping("/Modules/")
    public List<AssessmentDTO> getUpcomingExams(@RequestBody String[] moduleids){
        List<Assessment> assessments = assessmentRepository.getAssessmentsByModuleIdIn(moduleids);
        List<AssessmentDTO> assessmentDTOS = new ArrayList<>();
        for (Assessment a :
                assessments) {
            assessmentDTOS.add(new AssessmentDTO(a.getId(),a.getAssessmentTitle(),a.getModuleId(),a.getStarttime(),a.getEndtime()));
        }
        return assessmentDTOS;
    }

    @GetMapping("/Student/Passed/{id}")
    public List<AssessmentResultDTO> getExamScoresByStudentID(@PathVariable("id") String id){
        return AssessmentMapper.getAssessmentForStudent(passedExamRepository.getStudentexams(id).stream().limit(10).toList());
    }

    @GetMapping("/{id}")
    public Assessment getExamDetails(@PathVariable("id") String id){
        return assessmentRepository.findById(id).get() ;
    }

    @PostMapping("/")
    public Assessment newExamCreated(@RequestBody AssessmentCreationDTO dto){
        return assessmentRepository.save(new Assessment(null,dto.getAssessmentTitle(), dto.getModuleId(),dto.getStartTime(),dto.getEndTime(),false,null,null));
    }

    @PostMapping("/publish/{id}")
    public boolean publishExam(@PathVariable("id")String id){
        Assessment a = assessmentRepository.findById(id).get();
        a.setPublished(true);
        assessmentRepository.save(a);
        return true;
    }
    @PutMapping("/update/{id}")
    public boolean updateExam(@PathVariable("id")String id, @RequestBody AssessmentUpdateDTO dto){
        Assessment a = assessmentRepository.findById(id).get();
        a.setAssessmentTitle(dto.getAssessmentTitle());
        a.setStarttime(dto.getStartTime());
        a.setEndtime(dto.getEndTime());
        assessmentRepository.save(a);
        return true;
    }

    @DeleteMapping("/Delete/{id}")
    public boolean removeExam(@PathVariable("id")String id){
        assessmentRepository.deleteById(id);
        return true;
    }

    @PostMapping("/Qt")
    public Question addQuestion(@RequestBody QuestionCreationDTO dto){
        Assessment a = assessmentRepository.findById(dto.getIdExam()).get();
        return questionRepository.save(new Question(null,dto.getQuestion(),dto.getQtType(),dto.getDescription(),dto.getScore(),
                Arrays.stream(dto.getChoices()).toList(),null,a));
    }

    @PutMapping("/Qt/Update/{id}")
    public Question updateQuestion(@PathVariable("id") String id,@RequestBody QuestionUpdateDTO dto){
        Question qt = questionRepository.findById(id).get();

        qt.setChoices(Arrays.stream(dto.getChoices()).toList());
        qt.setDescription(dto.getDescription());
        qt.setQuestion(dto.getDescription());
        qt.setScore(dto.getScore());
        qt.setQtType(dto.getQtType());

        return questionRepository.save(qt);
    }
    @DeleteMapping("/Qt/Delete/{id}")
    public boolean removeQuestion(@PathVariable("id")String id){
        questionRepository.deleteById(id);
        return true;
    }


    @PostMapping("/Sol")
    public Solution addSolution(@RequestBody SolutionCreationDTO dto){
        Question qt = questionRepository.findById(dto.getQtid()).get();
        Solution sol = solutionRepository.save(new Solution(null,qt,dto.getAnswer()));
        qt.setSolution(sol);
        questionRepository.save(qt);
        return sol;
    }
    @PostMapping("/Sol/Update/{Id}")
    public Solution updateSolution(@PathVariable("Id")Long id,@RequestBody SolutionUpdateDTO dto){
        Solution sol = solutionRepository.findById(id).get();
        sol.setAnswer(dto.getAnswer());
        return solutionRepository.save(sol);
    }
}
