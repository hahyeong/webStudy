package kr.bit.service;

import kr.bit.bean.Subject;
import kr.bit.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public List<Subject> findAllSubject() {
        return subjectDao.findAllSubject();
    }

    public List<Subject> getApplySubject(int student_num){
        List <Subject> subject_apply= subjectDao.getApplySubject(student_num);
        return subject_apply;
    }

    public void insertEnroll(int student_num, int subject_num){

        subjectDao.insertEnroll(student_num,subject_num);
    }
    public void updateSubjectCurStu(int subject_num){
        subjectDao.updateSubjectCurStu(subject_num);
    }

    public void deleteInfo(int subject_num, int student_num){
        subjectDao.deleteInfo(subject_num, student_num);
    }


}
