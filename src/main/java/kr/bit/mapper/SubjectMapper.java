package kr.bit.mapper;

import kr.bit.bean.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SubjectMapper {

    @Select("select subject_num, subject_name, subject_point, subject_day, subject_time, subject_max_stu,subject_cur_stu " +
            "from subject_table " +
            "where subject_num in (select subject_num from enrolled_subject_table where student_num=#{student_num});")
    List<Subject> getApplySubject(int student_num);

    @Insert("insert into enrolled_subject_table (student_num,subject_num) values (#{student_num}, #{subject_num})")
    void insertEnroll(@Param("student_num") int student_num, @Param("subject_num") int subject_num);

    @Update("update subject_table set subject_cur_stu = subject_cur_stu+1 where subject_num = #{subject_num}")
    void updateSubjectCurStu(int subject_num);

    @Select("select * from subject_table")
    List<Subject> findAllSubject();

}
