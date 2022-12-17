package SchoolProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course {
    /*
    Course Sınıfı Özellikleri :
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
    private double note;
    static Integer counter=10;
    static Map< Integer , Course> courseMap=new HashMap<>();



    public Course(int courseCode,String courseName, String coursePrefix, String courseTeacher) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.coursePrefix = coursePrefix;
        this.courseTeacher = courseTeacher;

    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        if (note>=0 && note<=100){
            this.note=note;
        }else {
            System.out.println("gecerli not giriniz");
        }
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
                '}'+"\n";
    }
    public static void addTeacher(){
       try {
           Teacher.teacherList();
           boolean flag = true;
           Teacher key = null;
           do {
               System.out.println("Kurs Bilgileri giriniz \n" +
                       "cikmak icin 1'e basiniz");
               System.out.println("Ders adini giriniz");
               String courseName = scan.nextLine();

               if (courseName.equals("1")) {
                   System.out.println("Kurs ekleme kismindan ciktiniz");
                   flag = false;
                   break;
               }

               System.out.println("Kursun kısaltmasini giriniz");
               String prefix = scan.next();scan.nextLine();

               if (Teacher.teacherMap.containsKey(courseName)) {
                   key = Teacher.teacherMap.get(courseName);
                   System.out.println("Bu öğretmen bu dersin ögretmenidir");
                   Course course = new Course(counter, courseName, prefix, key.getTeacherName());

                   courseMap.put(counter, course);

                   counter++;

               } else {
                   try {

                       System.out.println(courseName + " dersine " + key.getTeacherName() + " giremez");

                   } catch (NullPointerException e) {
                       System.err.println("Key kısmı null olamaz");
                   }

               }

           } while (flag);
           System.out.println(Teacher.teacherMap);
           System.out.println(courseMap);

       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void printTeacher(){
        Teacher.teacherList();
    }

}
