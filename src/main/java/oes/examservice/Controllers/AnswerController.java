package oes.examservice.Controllers;

import oes.examservice.Entities.*;
import oes.examservice.Entities.CompositeKeys.CompositeAnswerKey;
import oes.examservice.Entities.CompositeKeys.CompositeExamKey;
import oes.examservice.Entities.Enums.QuestionType;
import oes.examservice.Models.StudentAnswer.StudentAnswerDTO;
import oes.examservice.Models.StudentAnswer.StudentPassedExamDTO;
import oes.examservice.Models.StudentAnswer.StudentScoreDTO;
import oes.examservice.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Answer")
public class AnswerController {
    @Autowired
    StudentAnswerRepository repo;
    @Autowired
    StudentPassedExamRepository exrepo;
    @Autowired
    AssessmentRepository arepo;
    @Autowired
    QuestionRepository qtrepo;


    @GetMapping("/")
    public List<StudentAnswer> getStudentAnswersByExamByStudent(@RequestBody CompositeExamKey key){
        return  repo.getStudentAnswers(key.getIdStudent(), key.getIdExam());
    }

    @PostMapping("/Pass")
    public StudentPassedExam passingExam(@RequestBody StudentPassedExamDTO dto){
        Assessment a = arepo.findById(dto.getIdExam()).get();
        return exrepo.save(new StudentPassedExam(new CompositeExamKey(dto.getIdstudent(),dto.getIdExam()),0.0,false,null,a));
    }

    @PostMapping("/Submit")
    public StudentAnswer answerSubmit(@RequestBody StudentAnswerDTO dto){
        StudentPassedExam ps = exrepo.findById(new CompositeExamKey(dto.getIdStudent(),dto.getIdExam())).get();
        StudentAnswer an = new StudentAnswer(new CompositeAnswerKey(dto.getIdStudent(),dto.getIdExam(), dto.getIdQt()),dto.getAnswer(),0,false,ps);
        Question qt = qtrepo.findById(dto.getIdQt()).get();

        an.setScore(an.getAnswer()==qt.getSolution().getAnswer()?qt.getScore():0);

        return repo.save(an);
    }

    @PostMapping("/Score")
    public StudentPassedExam scoreAnswer(@RequestBody StudentScoreDTO dto){
        StudentAnswer an = repo.findById(new CompositeAnswerKey(dto.getIdStudent(), dto.getIdExam(), dto.getIdQt())).get();
        StudentPassedExam ps = exrepo.findById(new CompositeExamKey(dto.getIdStudent(), dto.getIdExam())).get();
        ps.setFinalscore(ps.getFinalscore()-an.getScore() + dto.getScore());
        an.setScore(dto.getScore());
        an.setCorrectanswer(dto.isCorrectAnswer());
        repo.save(an);
        return exrepo.save(ps);
    }

    @PostMapping("/CalculateFinalScore")
    public StudentPassedExam calculateScore(@RequestBody CompositeExamKey key){
        List<StudentAnswer> answers = repo.getStudentAnswers(key.getIdStudent(), key.getIdExam());
        StudentPassedExam ps = exrepo.findById(new CompositeExamKey(key.getIdStudent(), key.getIdExam())).get();
        ps.setCorrected(true);
        double sumscore = answers.stream().mapToDouble(o->o.getScore()).sum();
        ps.setFinalscore(sumscore);
        return exrepo.save(ps);
    }
}
