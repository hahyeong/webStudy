package kr.bit.controller;

import kr.bit.bean.Student;
import kr.bit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Resource(name = "loginBean")
    private Student loginBean;

    @GetMapping("login")
    public String login(@ModelAttribute("loginProcBean") Student loginProcBean, Model model, @RequestParam(value = "fail", defaultValue = "false") boolean fail) {
        model.addAttribute("loginProcBean", loginProcBean);
        model.addAttribute("fail", fail);
        System.out.println("여기?");
        // 로그인 빈을 추가하여 JSP에서 사용할 수 있도록 합니다.
        return "login";
    }

    @PostMapping("login_proc")
    public String login_proc(@Valid @ModelAttribute("loginProcBean") Student loginProcBean, BindingResult result) {

//        System.out.println(result.getObjectName());
        if(result.hasErrors()) {
            return "login";
        }

        studentService.getLoginStudent(loginProcBean);

        if(loginBean.isStudentLogin() == true) {
            return "redirect:/list";
        } else {
            return "login_fail";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        loginBean.setStudentLogin(false);
        return "logout";
    }

    @GetMapping("/not_login")
    public String not_login() {
        return "not_login";
    }
}
