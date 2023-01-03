package Trial.onetoone;


import Trial.onetomany.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.event.DocumentEvent;
import java.util.Arrays;
import java.util.List;

public class FetchRunner01 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Developer01.class).addAnnotatedClass(Laptop01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //Adı Pc alan kisilerdenYusuf olanları bana getir
        Developer01 std1=session.get(Developer01.class,1000);
        System.out.println(std1.getLaptop());





        tx.commit();
        session.close();
        sf.close();
    }
}
