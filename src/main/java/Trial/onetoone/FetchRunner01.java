package Trial.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class FetchRunner01 {
    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Developer01.class).addAnnotatedClass(Laptop01.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

       // //Id si 1 olan olan laptopun sahibinin bilgilerini getir
       // Developer01 obj1=session.get(Developer01.class,100);
       // System.out.println(obj1.getLaptop());

       // //DEvops bransli olan kisinin tüm bilgilerini getir

       // String hqlQuery="From Developer01 s Where s.branch='Devops'";

       //Developer01 a=session.createQuery(hqlQuery,Developer01.class).uniqueResult();
       //System.out.println(a.getBranch());
       //System.out.println(a);

        // !!! Kesişim kümesini getirelim ( Inner Join )*************************
        /*String hqlQuery1="SELECT s.brand,d.name FROM Laptop01 s INNER JOIN FETCH Developer01 d on s.id=d.laptop.id";
        //        String hqlQuery ="SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary04 d on s.id=d.student";

        List<Object[]> obj1=session.createQuery(hqlQuery1).getResultList();
        obj1.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        // Kısaca bütün Developerlar ve Laptopu olan öğrencileri istiyorum
        String hqlQuery="Select s.serialNo,d.name From Laptop01 s LEFT JOIN FETCH Developer01 d on s.id=d.laptop";
        List<Object[]> obj1=session.createQuery(hqlQuery).getResultList();
        obj1.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });*/

        // kısaca : Bütün DEveloperlar ve laptopu olan developarlar

        String hqlQuery2="Select s.serialNo,d.name From Laptop01 s RIGHT JOIN FETCH Developer01 d on s.id=d.laptop";
        List<Object[]> obj2=session.createQuery(hqlQuery2).getResultList();
        obj2.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });









        tx.commit();
        session.close();
        sf.close();
    }
}
