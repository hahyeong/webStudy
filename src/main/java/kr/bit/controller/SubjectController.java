package kr.bit.controller;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import kr.bit.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String insertEnroll(@RequestParam("subject_num") int subject_num,
                               @RequestParam("student_num") int student_num, Model model) {
//        List<Subject> subject_apply = subjectService.getApplySubject(student_num);
        model.addAttribute("subject_num", subject_num);
        model.addAttribute("student_num", student_num);
//        model.addAttribute("subject_apply", subject_apply);
        subjectService.insertEnroll(subject_num, student_num);
        subjectService.updateSubjectCurStu(subject_num);
        return "main";
    }

    @GetMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Student loginProcBean = (Student) session.getAttribute("loginProcBeanSession");
        System.out.println(loginProcBean);
        List<Subject> allSubject = subjectService.findAllSubject();
        List<Subject> subject_apply = subjectService.getApplySubject(loginProcBean.getStudent_num());
//        List<Subject> allSubjectByUserId = subjectService.findAllSubjectByUserId(loginBean.getStudent_num());
        model.addAttribute("subjectBean", allSubject);
//        model.addAttribute("allSubjectByUserIdBean", allSubjectByUserId);
        model.addAttribute("allSubjectByUserIdBean", subject_apply);
        return "main";
    }
}