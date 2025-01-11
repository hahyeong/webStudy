package kr.bit.service;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import kr.bit.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Resource(name="loginBean")
    private Student loginBean;

    public void getLoginStudent(Student loginProcBean) {
        Student loginProcBean2 = studentDao.getLoginStudent(loginProcBean);

        if(loginProcBean2 != null) {
            loginBean.setStudent_num(loginProcBean2.getStudent_num());
            loginBean.setStudent_name(loginProcBean2.getStudent_name());
            loginBean.setStudentLogin(true);
        }
    }
}
