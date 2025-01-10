package kr.bit.bean;

public class Subject {
    private int subject_num;
    private String subject_name;
    private double subject_point;
    private String subject_day;
    private String subject_time;
    private int subject_cur_stu;
    private int subject_max_stu;

    public Subject() {}

    public Subject(int subject_num, String subject_name, double subject_point, String subject_day, String subject_time) {
        this.subject_num = subject_num;
        this.subject_name = subject_name;
        this.subject_point = subject_point;
        this.subject_day = subject_day;
        this.subject_time = subject_time;
        this.subject_cur_stu = 0;
        this.subject_max_stu = 20;
    }

    public int getSubject_num() {
        return subject_num;
    }

    public void setSubject_num(int subject_num) {
        this.subject_num = subject_num;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public double getSubject_point() {
        return subject_point;
    }

    public void setSubject_point(double subject_point) {
        this.subject_point = subject_point;
    }

    public String getSubject_day() {
        return subject_day;
    }

    public void setSubject_day(String subject_day) {
        this.subject_day = subject_day;
    }

    public String getSubject_time() {
        return subject_time;
    }

    public void setSubject_time(String subject_time) {
        this.subject_time = subject_time;
    }

    public int getSubject_cur_stu() {
        return subject_cur_stu;
    }

    public void setSubject_cur_stu(int subject_cur_stu) {
        this.subject_cur_stu = subject_cur_stu;
    }

    public int getSubject_max_stu() {
        return subject_max_stu;
    }

    public void setSubject_max_stu(int subject_max_stu) {
        this.subject_max_stu = subject_max_stu;
    }
}
