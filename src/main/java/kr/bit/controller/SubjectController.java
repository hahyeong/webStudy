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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Resource(name = "loginBean")
    private Student loginBean;

    @PostMapping("/apply_pro")
    public String insertEnroll(@RequestParam("subject_num") int subject_num) {
        System.out.println("loginBean = " + loginBean.getStudent_num());
        System.out.println("subjectBean = " + subject_num);
        subjectService.insertEnroll(loginBean.getStudent_num(), subject_num);
        subjectService.updateSubjectCurStu(subject_num);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Student loginProcBean = (Student) session.getAttribute("loginProcBeanSession");
        List<Subject> allSubject = subjectService.findAllSubject();
        List<Subject> subject_apply = subjectService.getApplySubject(loginProcBean.getStudent_num());
        model.addAttribute("subjectBean", allSubject);
        model.addAttribute("allSubjectByUserIdBean", subject_apply);
        return "main";
    }
}