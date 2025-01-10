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

    public List<Subject> getApplySubject(int subject_id){
        List<Subject> subject_apply= subjectMapper.getApplySubject(subject_id);
        return subject_apply;
    }
    public void insertEnroll(int student_num, int subject_num){
        subjectMapper.insertEnroll(student_num,subject_num);
    }
    public void updateSubjectCurStu(int subject_num){
        subjectMapper.updateSubjectCurStu(subject_num);
    }

}
