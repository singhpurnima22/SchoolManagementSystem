package com.school.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.connection.HyberConfig;
import com.school.model.Classes;
import com.school.model.Student;
import com.school.model.Subject;

public class SubjectOperation {
	SessionFactory sf = null;

	public SubjectOperation() {
		sf = HyberConfig.getSessionFactory();
	}

	public void addSubject(String name) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Subject sub = new Subject();
		sub.setSubName(name);
		session.save(sub);
		tr.commit();
	}

	public List<Subject> showAll() {
		List<Subject> suball = null;
		try (Session session = sf.openSession()) {
			TypedQuery qry = session.createQuery("from Subject");
			suball = qry.getResultList();
		}

		return suball;
	}

	public List<Subject> getSubjectWithClass() {
		List<Subject> suball = null;
		try (Session session = sf.openSession()) {
			TypedQuery qry = session.createQuery("from Subject where classobj != null");
			suball = qry.getResultList();
		}

		return suball;
	}

	public List<Subject> getSubjectByIds(String[] subIds) {

		List<Subject> suball = new ArrayList<>();
		try (Session session = sf.openSession()) {
			List<Integer> subIdList = new ArrayList<>();
			for (int i = 0; i < subIds.length; i++) {
				subIdList.add(Integer.parseInt(subIds[i]));
			}

			TypedQuery qry = session.createQuery("from Subject where subId in :subIds").setParameterList("subIds",
					subIdList);
			suball = qry.getResultList();
		}

		return suball;
	}

}
