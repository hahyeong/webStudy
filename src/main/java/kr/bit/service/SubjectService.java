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

//    public List<Subject> findAllSubjectByUserId(int student_num) {
//        return subjectDao.findAllSubjectByUserId(student_num);
//    }
}
