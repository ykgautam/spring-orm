package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * spring orm CRUD operation
 *
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;

		while (go) {
			System.out.println("press 1 to add new student");
			System.out.println("press 2 to display all students");
			System.out.println("press 3 to get detail of single student");
			System.out.println("press 4 to delete single student");
			System.out.println("press 5 to update single student");
			System.out.println("press 6 to exit");

			try {
				System.out.println("enter ur choice...");
				int choice = Integer.parseInt(br.readLine());

				switch (choice) {

				case 1:
//					add new student
					System.out.println("enter student id");
					int id = Integer.parseInt(br.readLine());

					System.out.println("enter student name");
					String name = br.readLine();

					System.out.println("enter student city");
					String city = br.readLine();

					Student student = new Student(id, name, city);
					student.setStudentId(id);
					student.setStudentName(name);
					student.setStudentCity(city);
					studentDao.insert(student);
					System.out.println("student data added succefully");
					break;

				case 2:
//					display all students
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("student's id: " + st.getStudentId());
						System.out.println("student's name: " + st.getStudentName());
						System.out.println("student's city: " + st.getStudentCity());
						System.out.println("-----------------------------------------");
					}
					break;

				case 3:
//					get single student

					System.out.println("enter student id");
					int sid = Integer.parseInt(br.readLine());
					Student st = studentDao.getStudent(sid);

					System.out.println("student's id: " + st.getStudentId());
					System.out.println("student's name: " + st.getStudentName());
					System.out.println("student's city: " + st.getStudentCity());
					System.out.println("-----------------------------------------");
					break;

				case 4:
//					delete single student
					System.out.println("enter student id");
					sid = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(sid);
					System.out.println("student details got deleted");
					break;

				case 5:
//					update single student

					System.out.println("enter student id");
					id = Integer.parseInt(br.readLine());

					System.out.println("enter student name");
					name = br.readLine();

					System.out.println("enter student city");
					city = br.readLine();

					Student student1 = new Student(id, name, city);
					student1.setStudentId(id);
					student1.setStudentName(name);
					student1.setStudentCity(city);

					studentDao.updateStudent(student1);
					break;

				case 6:
//					exit
					System.out.println(" switch got exit");
					go = false;
					break;

				default:
					System.out.println("invalid input try with another one between 1 and 6");
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("got exit from while loop");
	}
}
