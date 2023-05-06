package com.school.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.connection.HyberConfig;
import com.school.model.Classes;
import com.school.model.Student;

public class StudentOperation {
	SessionFactory sf = null;

	public StudentOperation() {
		sf = HyberConfig.getSessionFactory();
	}

	public void addStudent(String stname, Integer classId) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		ClassesOperation co = new ClassesOperation();
		Classes cl = co.getClassById(classId);

		Student st = new Student();
		st.setStudentName(stname);
		st.setClassobj(cl);

		/*
		 * List<Student> studentList = new ArrayList<>(); studentList.add(st);
		 * cl.setStudentList(studentList);
		 */
		session.save(st);
		tr.commit();
	}

	public List<Student> showAll() {
		Session session = sf.openSession();
		TypedQuery qry = session.createQuery("from Student");
		List<Student> stdall = qry.getResultList();
		return stdall;
	}
}
