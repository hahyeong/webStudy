package kr.bit.mapper;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select student_num, student_name from student_table where student_id = #{student_id} and student_pw = #{student_pw}")
    Student getLoginStudent(Student loginProcBean);

//    @Select("select subject_num,subject_name,subject_point,subject_day,subject_time,subject_max_stu,subject_cur_stu " +
//            "from subject_table " +
//            "where subject_num in (select subject_num from enrolled_subject_table where student_num= #{student_num});")
//    List<Subject> alreadyAppliedSubject(int student_num);

}
