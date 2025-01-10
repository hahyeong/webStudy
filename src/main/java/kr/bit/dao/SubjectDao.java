package kr.bit.dao;

import kr.bit.bean.Subject;
import kr.bit.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao {

    @Autowired
    private SubjectMapper subjectMapper;

    public List<Subject> findAllSubject() {
        return subjectMapper.findAllSubject();
    }

    public List<Subject> findAllSubjectByUserId(int student_num) {
        return subjectMapper.findAllSubjectByUserId(student_num);
    }

}
