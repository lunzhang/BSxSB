/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import Hibernate.HibernateUtil;
import Mapping.POJO.Student;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author lun
 */
public class StudentDAO {
    public  List<Student> allStudent(){
        Session session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createSQLQuery(
                "SELECT * FROM students")
                .addEntity(Student.class);
          List<Student> allStudents = query.list();
          session.close();
        return allStudents;
    }
}
