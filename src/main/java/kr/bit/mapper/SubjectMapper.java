package kr.bit.mapper;

import kr.bit.bean.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubjectMapper {

    @Select("select * from subject_table")
    List<Subject> findAllSubject();

//    @Select("select distinct sub.subject_name " +
//            "from student_table stu, subject_table sub, enrolled_subject_table enr " +
//            "where enr.subject_num=sub.subject_num " +
//            "and enr.student_num=#{student_num};")
//    List<Subject> findAllSubjectByUserId(int student_num);
}
