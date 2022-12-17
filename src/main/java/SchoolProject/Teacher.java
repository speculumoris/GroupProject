package SchoolProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teacher {
    static Scanner scan=new Scanner(System.in);
    private String teacherName;
    private String tTelNo;
    private String branch;

    static Map<String,Teacher> teacherMap=new HashMap<>();


    public Teacher(String teacherName, String tTelNo) {
        this.teacherName = teacherName;
        this.tTelNo = tTelNo;

    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String gettTelNo() {
        return tTelNo;
    }

    public void settTelNo(String tTelNo) {
        this.tTelNo = tTelNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "teacherName='" + teacherName + '\'' +
                ", tTelNo='" + tTelNo + '\'' +
                '}'+"\n";
    }

    public static void teacherList(){
        boolean flag=true;
      do {
          System.out.println("Ogretmenin bransını giriniz: ");
          System.out.println("Cikmak icin 1'e basiniz");
          String teachBranch = scan.nextLine();

          if (teachBranch.equals("1")){
              System.out.println("Ogretmen ekleme blogundan ciktiniz");
              flag=false;
              break;
          }
          System.out.println("Ogretmenin adini soyadini giriniz");
          String teachNameSurname = scan.nextLine();
          System.out.println("Ogretmenin Telefon numarasını giriniz");
          String telNo = scan.nextLine();

          Teacher teacherObj = new Teacher(teachNameSurname, telNo);
          teacherMap.put(teachBranch, teacherObj);

      }while (flag);
    }
}
