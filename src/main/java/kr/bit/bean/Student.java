package kr.bit.bean;

public class Student {
    private int student_num;
    private String student_name;
    private String student_id;
    private String student_pw;

    public Student() {}

    public Student(int student_num, String student_name, String student_id, String student_pw) {
        this.student_num = student_num;
        this.student_name = student_name;
        this.student_id = student_id;
        this.student_pw = student_pw;
    }

    public int getStudent_num() {
        return student_num;
    }

    public void setStudent_num(int student_num) {
        this.student_num = student_num;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_pw() {
        return student_pw;
    }

    public void setStudent_pw(String student_pw) {
        this.student_pw = student_pw;
    }
}
