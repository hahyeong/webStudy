package kr.bit.service;

import kr.bit.bean.Subject;
import kr.bit.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

    public List<Subject> getApplySubject(int student_num){
        List <Subject> subject_apply= subjectDao.getApplySubject(student_num);
        return subject_apply;
    }

//    public List<Subject> findAllSubjectByUserId(int student_num) {
//        return subjectDao.findAllSubjectByUserId(student_num);
//    }

    public void insertEnroll(int student_num, int subject_num){
        subjectDao.insertEnroll(student_num,subject_num);
    }
    public void updateSubjectCurStu(int subject_num){
        subjectDao.updateSubjectCurStu(subject_num);
    }

}
