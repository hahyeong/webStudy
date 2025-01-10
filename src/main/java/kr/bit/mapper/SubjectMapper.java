package kr.bit.mapper;

import kr.bit.bean.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SubjectMapper {

    @Select("select subject_num,subject_name,subject_point,subject_day,subject_time,subject_max_stu,subject_cur_stu " +
            "from subject_table " +
            "where subject_num in (select subject_num from enrolled_subject_table where student_num=#{student_num});")
    List<Subject> getApplySubject(int student_num);

    @Insert("insert into enroll_table (student_num,subject_num) values (#{student_num, #{subject_num})")
    void insertEnroll(int student_num, int subject_num);

    @Update("update suject_table set subject_cur_stu = subject_cur_stu+1 where subject_num = #{subject_num}")
    void updateSubjectCurStu(int subject_num);

    @Select("select * from subject_table")
    List<Subject> findAllSubject();

//    @Select("select distinct sub.subject_name " +
//            "from student_table stu, subject_table sub, enrolled_subject_table enr " +
//            "where enr.subject_num=sub.subject_num " +
//            "and enr.student_num=#{student_num};")
//    List<Subject> findAllSubjectByUserId(int student_num);

}
