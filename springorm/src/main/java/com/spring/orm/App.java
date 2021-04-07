package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
//	private static Student Student;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		Student student = new Student(222, "mohit", "agra");

//		int r = studentDao.insert(student);
//		System.out.println("inserted successfully " + r);

		List<Student> studentList = studentDao.getAllStudents();
		System.out.println(studentList.get(0));
		System.out.println(studentList.get(1));

	}
}
