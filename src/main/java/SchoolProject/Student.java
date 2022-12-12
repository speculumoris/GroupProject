package SchoolProject;

import java.util.*;

public class Student {
    static Scanner scan =new Scanner(System.in);
    static Integer id=1;
    static Map<Integer,Teacher> teacherMap=new HashMap<>();


    public static void girisPanel(){
        System.out.println("lutfen yapmak istediginiz islemi seciniz");
        int secim= scan.nextInt();
        switch (secim){
            case 1:
                teacherAdd();
                girisPanel();
        }
    }

    private static void teacherAdd() {
        boolean flag=true;
        do {


            System.out.println("lutfen ogretmen ismini,tel numarsını,branch prefixi giriniz giriniz\n" +
                    "cikmak icin 1 tusuna basini");
            String teacherNAme = scan.nextLine();
            if (teacherNAme.equals("1")){
                flag=false;
                break;
            }
            String teacherTel = scan.nextLine();
            String teacherBranch = scan.nextLine();
            Teacher teacher = new Teacher(teacherNAme, teacherTel, teacherBranch);
            System.out.println(teacher);
            courseInfo(teacher);

        }while (flag);

    }

    private static void courseInfo(Teacher teacher) {
      boolean flag=true;

           System.out.println("Kurs adını,kurs kodunu,kurs prefixi giriniz "+
                   "cikmak icin 1 tusuna basiniz");

           String courseName = scan.nextLine();
           int courseCode = scan.nextInt();
           scan.nextLine();
           String coursePrefix = scan.nextLine();
           if (teacher.getBranch().equals(coursePrefix)) {
               Course course = new Course(courseName, courseCode, coursePrefix, teacher.getTeacherName());
               System.out.println("dersin öğretmen bilgisi: " + teacher);
               System.out.println("dersin genel bilgileri: " + course);
           } else {
               System.out.println("bu öğretmen bu dersin öğretmeni değildir");
           }

    }

    public static void main(String[] args) {
        teacherAdd();
    }
}

