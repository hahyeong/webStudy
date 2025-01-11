package kr.bit.controller;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import kr.bit.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/apply_pro")
    public String insertEnroll(@RequestParam("subject_num") int subject_num, Model model) {
        model.addAttribute("subject_num", subject_num);
        model.addAttribute("student_num", loginBean.getStudent_num());

        subjectService.insertEnroll( loginBean.getStudent_num(), subject_num);

        subjectService.updateSubjectCurStu(subject_num);
        return "/apply_success";
    }

    @GetMapping("/list")
    public String list(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Student loginProcBean = (Student) session.getAttribute("loginProcBeanSession");
        List<Subject> allSubject = subjectService.findAllSubject();

        model.addAttribute("subjectBean", allSubject);
        List<Subject> subject_apply = subjectService.getApplySubject(loginBean.getStudent_num());
        model.addAttribute("subject_apply", subject_apply);

        return "/main";
    }

    @GetMapping("/re_get")
    public String re_get(@RequestParam("subject_num") int subject_num, Model model) {
        List<Subject> allSubject = subjectService.findAllSubject();
        model.addAttribute("subjectBean", allSubject);
        List<Subject> subject_apply = subjectService.getApplySubject(loginBean.getStudent_num());
        model.addAttribute("subject_apply", subject_apply);

        return "/main";
    }

    @GetMapping("/delete_pro")
    public String deleteEnroll(@RequestParam("subject_num") int subject_num, Model model) {
        model.addAttribute("subject_num", subject_num);
        model.addAttribute("student_num", loginBean.getStudent_num());

        subjectService.deleteEnroll( loginBean.getStudent_num(), subject_num);

        subjectService.updateSubjectCurStu_delete(subject_num);
        return "/delete_success";
    }
}