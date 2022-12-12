package SchoolProject;

import java.util.Scanner;

public class Course {
    /*Course Sınıfı Özellikleri :
    Nitelikler : name,
    code,
    prefix,
    note,
    Teacher
    Metotlar :
    Course()Constructor ,
    addTeacher() ,
    printTeacher()

     */
    static Scanner scan=new Scanner(System.in);
    private String courseName;
    private int courseCode;
    private String coursePrefix;
    private String courseTeacher;

    public Course(String courseName, int courseCode, String coursePrefix, String courseTeacher) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.coursePrefix = coursePrefix;
        this.courseTeacher = courseTeacher;
    }

    public static Scanner getScan() {
        return scan;
    }

    public static void setScan(Scanner scan) {
        Course.scan = scan;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCoursePrefix() {
        return coursePrefix;
    }

    public void setCoursePrefix(String coursePrefix) {
        this.coursePrefix = coursePrefix;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = String.valueOf(courseTeacher);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode=" + courseCode +
                ", coursePrefix='" + coursePrefix + '\'' +
                ", courseTeacher=" + courseTeacher +
                '}';
    }
}
