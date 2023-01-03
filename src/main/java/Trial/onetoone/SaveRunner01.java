package Trial.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import warehouseproject.Urunler;

import java.util.Scanner;

public class SaveRunner01 {
    static int id=1000;
    static int id1=100000;
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        Configuration con=new Configuration().configure().addAnnotatedClass(Developer01.class).addAnnotatedClass(Laptop01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        do {
            System.out.println("bilgileri giriniz çıkış için 1'e basınız");
            Laptop01 lp1=new Laptop01();
            lp1.setId(id1);
            id1++;
            System.out.println("Laptop kimin adına alındı");
            lp1.setName(scan.nextLine());
            if (lp1.getName().equals("1")){
                break;
            }
            System.out.println("Laptop marka giriniz");
            lp1.setMark(scan.nextLine());
            Laptop01 lp2=new Laptop01(lp1.getId(), lp1.getName(), lp1.getMark());
            Developer01 dev1=new Developer01();
            dev1.setId(id);
            id++;
            System.out.println("Lutfen  adınızı giriniz");
            dev1.setName(scan.nextLine());
            Developer01 dev2=new Developer01(dev1.getId(),dev1.getName(),lp2);



            session.save(dev2);
            session.save(lp2);


        }while(true);


        tx.commit();
        session.close();
        sf.close();
    }
}
