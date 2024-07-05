package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
    public static void main( String[] args ) {
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        // INSERT
//        Student student1=new Student();
//        student1.setId(105);
//        student1.setName("David");
//        student1.setCity("London");
//        int result = studentDao.insert(student1);
//        System.out.println(result + " students added");
        
        // MODIFY
//        Student student2=new Student();
//        student2.setId(103);
//        student2.setName("Tokyo");
//        student2.setCity("Japan");
//        int result = studentDao.modify(student2);
//        System.out.println(result + " students updated");
        
        // DELETE
//        int result = studentDao.delete(105);
//        System.out.println(result + " students deleted");
        
        // GET STUDENT
//        Student student = studentDao.getStudent(103);
//        System.out.println(student);
        
        // GET ALL STUDENTS
          List<Student> students = studentDao.getStudents();
          for(Student s: students) {
        	  System.out.println(s);
          }
    }
}
