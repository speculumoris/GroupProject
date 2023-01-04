package Trial.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        University01 uni1=new University01(1,"YTU");

        Student01 std1=new Student01(100,"Yusuf",90,uni1);
        Student01 std2=new Student01(101,"Sefa",90,uni1);
        Student01 std3=new Student01(102,"Bay",90,uni1);
        Student01 std4=new Student01(103,"Sef",90,uni1);

        Configuration con=new Configuration().configure().addAnnotatedClass(University01.class).addAnnotatedClass(Student01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(std1);
        session.save(std2);
        session.save(std3);
        session.save(std4);


        session.save(uni1);


        tx.commit();
        session.close();
        sf.close();
    }
}
