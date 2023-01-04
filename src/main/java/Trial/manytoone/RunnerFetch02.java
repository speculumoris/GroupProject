package Trial.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch02 {

    public static void main(String[] args) {



        Configuration con=new Configuration().configure().addAnnotatedClass(Student01.class).addAnnotatedClass(University01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

       Student01 student = session.get(Student01.class,101);
        System.out.println(student.getGrade());

        // !!! HQL ile 1 id li üniversiteye giden bütün öğrencileri bulalım
       // String hqlQuery="FROM Student01 s WHERE s.university.id=1";
       // List<Student01> resultList1 =
       //         session.createQuery(hqlQuery , Student01.class).getResultList();
       // resultList1.forEach(s->System.out.println(s));

        tx.commit();
        session.close();
        sf.close();
    }
}
