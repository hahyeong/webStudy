package kr.bit.controller;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import kr.bit.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Resource(name = "loginBean")
    private Student loginBean;

    @GetMapping("/apply_pro")
    public String insertEnroll(@RequestParam("subject_num") int subject_num,
                               @RequestParam("student_num") int student_num, Model model) {
        List<Subject> subject_apply = subjectService.getApplySubject(student_num);
        model.addAttribute("subject_num", subject_num);
        model.addAttribute("student_num", student_num);
        model.addAttribute("subject_apply", subject_apply);
        subjectService.insertEnroll(subject_num, student_num);
        subjectService.updateSubjectCurStu(subject_num);
        return "main";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Subject> allSubject = subjectService.findAllSubject();
//        List<Subject> allSubjectByUserId = subjectService.findAllSubjectByUserId(loginBean.getStudent_num());

        //이거
        List<Subject> applySubject = subjectService.getApplySubject(1);

        model.addAttribute("subjectBean", allSubject);
//        model.addAttribute("allSubjectByUserIdBean", allSubjectByUserId);

        //이거
        model.addAttribute("applySubject", applySubject);
        return "main";
    }
}