package Trial.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SaveRunner01 {

    public static void main(String[] args) {
        Laptop01 lap1=new Laptop01(1,"Lenovo","123456");
        Laptop01 lap2=new Laptop01(2,"Toshiba","123456");
        Laptop01 lap3=new Laptop01(3,"MAckbook","123456");
        Laptop01 lap4=new Laptop01(4,"Mackbook","123456");



        Developer01 dev1=new Developer01(100,"Arif","asdfg@gmail.com","Devops",lap1);
        Developer01 dev2=new Developer01(101,"Sefa","asdfga@gmail.com","Salesforce",lap2);
        Developer01 dev3=new Developer01(102,"yusuf","asadfg@gmail.com","Java",lap3);
        Developer01 dev4=new Developer01(103,"yusuf","asadfg@gmail.com","Java",null);

        dev1.setLaptop(lap1);
        dev2.setLaptop(lap2);
        dev3.setLaptop(lap3);


        Configuration con=new Configuration().configure().addAnnotatedClass(Developer01.class).addAnnotatedClass(Laptop01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

       // session.save(lap1);
       // session.save(lap2);
       // session.save(lap3);
       // session.save(dev1);
       // session.save(dev2);
        session.save(dev4);
        session.save(lap4);



        tx.commit();
        session.close();
        sf.close();
    }
}
