package kr.bit.dao;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import kr.bit.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private StudentMapper studentMapper;

    public Student getLoginStudent(Student loginProcBean) {
        return studentMapper.getLoginStudent(loginProcBean);
    }

//    public List<Subject> alreadyAppliedSubject(int student_num){
//        return studentMapper.alreadyAppliedSubject(student_num);
//    }

}
