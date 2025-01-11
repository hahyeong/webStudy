package kr.bit.mapper;

import kr.bit.bean.Student;
import kr.bit.bean.Subject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface StudentMapper {

    @Select("select student_num, student_name from student_table where student_id = #{student_id} and student_pw = #{student_pw}")
    Student getLoginStudent(Student loginProcBean);
}
