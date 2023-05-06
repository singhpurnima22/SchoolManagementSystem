package com.school.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.connection.HyberConfig;
import com.school.model.Classes;
import com.school.model.Student;
import com.school.model.Subject;
import com.school.model.Teacher;

public class ClassesOperation {
	SessionFactory sf = null;

	public ClassesOperation() {
		sf = HyberConfig.getSessionFactory();
	}

	public void addClasses(Integer standard) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Classes cs = new Classes();
		cs.setStandard(standard);
		session.save(cs);
		tr.commit();
		session.close();
	}

	public List<Classes> showAll() {
		List<Classes> clsall = null;
		try (Session session = sf.openSession()) {
			TypedQuery qry = session.createQuery("from Classes");
			clsall = qry.getResultList();
		}

		return clsall;

	}

	public void assignSubject(String classId, String[] subIds) {
		try (Session session = sf.openSession()) {
			Transaction tr = session.beginTransaction();

			// get Classes object using classId
			ClassesOperation co = new ClassesOperation();
			Classes cs = co.getClassById(Integer.parseInt(classId));

			// get Subject Object List using subIds

			List<Subject> subList = new ArrayList<>();
			SubjectOperation so = new SubjectOperation();
			subList = so.getSubjectByIds(subIds);

			for (Subject s : subList) {
				s.setClassobj(cs);
				session.saveOrUpdate(s);
			}

			cs.setSubjectlist(subList);
			session.saveOrUpdate(cs);
			tr.commit();
		}
	}

	public void assignTeacherToSubject(Subject sub, List<Teacher> teacherList) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Classes cs = sub.getClassobj();
		cs.setTeacherlist(teacherList);
	}

	public void assignStudent(Classes cs, Student student) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		List<Student> sList = new ArrayList<>();
		sList.add(student);
		cs.setStudentList(sList);
		session.save(cs);
		tr.commit();
		session.close();
	}

	public Classes getClassById(Integer classId) {
		Classes cls = null;
		try (Session session = sf.openSession()) {
			TypedQuery qry = session.createQuery("from Classes where classId=" + classId);
			cls = (Classes) qry.getSingleResult();
		}

		return cls;

	}

	public List<Classes> getClassByIds(String[] classIds) {

		List<Classes> clsall = new ArrayList<>();
		try (Session session = sf.openSession()) {
			List<Integer> clsIdList = new ArrayList<>();
			for (int i = 0; i < classIds.length; i++) {
				clsIdList.add(Integer.parseInt(classIds[i]));
			}

			TypedQuery qry = session.createQuery("from Classes where classID in :clsIds").setParameterList("clsIds",
					clsIdList);
			clsall = qry.getResultList();
		}

		return clsall;
	}
}
