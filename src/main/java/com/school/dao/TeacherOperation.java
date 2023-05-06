package com.school.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.connection.HyberConfig;
import com.school.model.Classes;
import com.school.model.Subject;
import com.school.model.Teacher;

public class TeacherOperation {
	SessionFactory sf = null;

	public TeacherOperation() {
		sf = HyberConfig.getSessionFactory();
	}

	public void addTeacher(String name, Integer exp) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Teacher t = new Teacher();
		t.setTeacherName(name);
		t.setExperience(exp);
		session.save(t);
		tr.commit();
	}

	public List<Teacher> showAll() {
		Session session = sf.openSession();
		TypedQuery qry = session.createQuery("from Teacher");
		List<Teacher> teacher = qry.getResultList();
		return teacher;
	}

	public void assignTeacher(String teacherId, String[] classIds) {
		try(Session session = sf.openSession()){
			Transaction tr = session.beginTransaction();

			// get Classes object using classId
			TeacherOperation to = new TeacherOperation();
			Teacher teacher = to.getTeacherById(Integer.parseInt(teacherId));

			// get Subject Object List using subIds

			List<Classes> classList = new ArrayList<>();
			ClassesOperation co = new ClassesOperation();
			classList = co.getClassByIds(classIds);
			
			teacher.setClassobj(classList);

			session.saveOrUpdate(teacher);
			tr.commit();
		}
	}

	private Teacher getTeacherById(int id) {
		Session session = sf.openSession();
		TypedQuery qry = session.createQuery("from Teacher where tID="+id);
		Teacher teacher = (Teacher) qry.getSingleResult();
		return teacher;
	}
}