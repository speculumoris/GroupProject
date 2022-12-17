package SchoolProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
    /*name,
    stuNo,
    classes,
    course1,
    course2,
    course3,
    avarage,
    isPass
    Metotlar : Student(), addBulkExamNote(), isPass(), calcAvarage(), printNote()

     */
    private int stdNo;
    private String stdName;
    private String stdClass;
    private double mat;
    private double fizik;
    private double kimya;
    private double avarage;

    static Scanner scan = new Scanner(System.in);
    static int counter = 1000;
    static Map<Integer, Student> stdMap = new HashMap<>();

    public Student(String stdName, String stdClass, double mat, double fizik, double kimya) {
        this.stdNo = counter;
        this.stdName = stdName;
        this.stdClass = stdClass;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
    }

    public int getStdNo() {
        return stdNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdClass() {
        return stdClass;
    }

    public void setStdClass(String stdClass) {
        this.stdClass = stdClass;
    }

    public double getMat() {
        return mat;
    }

    public void setMat(double mat) {
        this.mat = mat;
    }

    public double getFizik() {
        return fizik;
    }

    public void setFizik(double fizik) {
        this.fizik = fizik;
    }

    public double getKimya() {
        return kimya;
    }

    public void setKimya(double kimya) {
        this.kimya = kimya;
    }

    public double getAvarage() {
        return avarage;
    }

    public void setAvarage(double avarage) {
        this.avarage = avarage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdNo='" + stdNo + '\'' +
                ", stdName='" + stdName + '\'' +
                ", stdClass='" + stdClass + '\'' +
                ", course1=" + mat +
                ", course2=" + fizik +
                ", course3=" + kimya +
                ", avarage=" + avarage +
                '}';
    }

    public static void stdInfo() {
        boolean flag = true;
        do {
            System.out.println("Ogrencinin ad-soyad giriniz:");
            String nameSurname = scan.nextLine();
            if (nameSurname.equals("1")) {
                System.out.println("Ogrenci ekleme kismindan ciktiniz");
                flag = false;
                break;
            }
            System.out.println("Ogrencinin numarasini giriniz:");
            String stdNo = scan.nextLine();
            System.out.println("Sinifini giriniz: ");
            String stdClass = scan.nextLine();

            System.out.println("Not girislerini yapiniz");
            System.out.println("Ogrencinin Matematik notunu giriniz:");
            double matNote = scan.nextDouble();
            System.out.println("Fizik notunu giriniz: ");
            double fiziknote = scan.nextDouble();
            System.out.println("Kimya notunu giriniz:");
            double kimyaNote = scan.nextDouble();scan.nextLine();
            Student std = new Student(nameSurname, stdClass, matNote, fiziknote, kimyaNote);

            stdMap.put(counter, std);

            counter++;
        } while (flag);
        System.out.println(stdMap);

    }

    public static void main(String[] args) {
        Student.stdInfo();

    }
}

