
package de.tekup.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.test.WhiteTestApplication;
import de.tekup.whitetest.soap.ws.whitetest.Exam;
import de.tekup.whitetest.soap.ws.whitetest.ObjectFactory;
import de.tekup.whitetest.soap.ws.whitetest.Student;
import de.tekup.whitetest.soap.ws.whitetest.StudentRequest;
import de.tekup.whitetest.soap.ws.whitetest.WhiteTestResponse;
import de.tekup.whitetest.soap.ws.whitetest.Student.Address;
@Service
public class WhiteTestService {
	
	public  List<Student> students = new ArrayList<Student>();
	public  List<Exam> exams = new ArrayList<Exam>();


	public WhiteTestResponse checkExam(StudentRequest studentRequest) throws DatatypeConfigurationException
	{
		
		Address a1 = new Address();
		a1.setCity("city1");
		a1.setStreet("street1");
		a1.setPosteCode("123456");
		
		Address a2 = new Address();
		a2.setCity("city2");
		a2.setStreet("street2");
		a2.setPosteCode("123456");
		
		Address a3 = new Address();
		a3.setCity("city3");
		a3.setStreet("street3");
		a3.setPosteCode("123456");
		
		Address falseAddress = new Address();
		falseAddress.setCity("false city");
		falseAddress.setStreet("false street");
		falseAddress.setPosteCode("no poste code");
		
		students.add(new Student(1,"student1",a1));
		students.add(new Student(2,"student2",a2));
		students.add(new Student(3,"student3",a3));
		
		exams.add(new Exam("code_OCA","OCA"));
		exams.add(new Exam("code_OCP","OCP"));
		
		Student falseStudent = new Student (-1, "false",falseAddress);
		Exam falseExam = new Exam ("-1","false");
		
		WhiteTestResponse response = new ObjectFactory().createWhiteTestResponse();
		
		
		//default response
		response.setExam(falseExam);
		response.setStudent(falseStudent);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = 
            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
		
		for (Student student : students) { 		

	           if (student.getId() == studentRequest.getStudentId())
	           {
	        	   System.out.println("student id : "+student.getId());
	        	   System.out.println("studentRequest id : "+studentRequest.getStudentId());
	        	   System.out.println(student.getId() == studentRequest.getStudentId());
	        	   System.out.println(student.toString());
	        	   response.setStudent(student);
	           }
	      }
		for (Exam exam : exams)
		{
			if (exam.getCode().equals(studentRequest.getExamCode()))
			{
				response.setExam(exam);
				response.setDate(now);
			}
		}

		return response;
	}

}

