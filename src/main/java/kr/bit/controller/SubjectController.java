package kr.bit.controller;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import kr.bit.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Resource(name = "loginSession")
    private Student loginSession;

    @GetMapping("/list")
    public String list(Model model) {
        List<Subject> allSubject = subjectService.findAllSubject();
        List<Subject> allSubjectByUserId = subjectService.findAllSubjectByUserId(loginSession.getStudent_num());
        model.addAttribute("subjectBean", allSubject);
        model.addAttribute("allSubjectByUserIdBean", allSubjectByUserId);
        return "main";
    }
}
