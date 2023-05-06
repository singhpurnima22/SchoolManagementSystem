package com.school.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "classinfo")
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classID;
	private Integer standard;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "classobj")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Student> studentList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "classobj")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Subject> subjectlist;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "classobj")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Teacher> teacherlist;

	@Override
	public String toString() {
		return "Classes [classID=" + classID + ", standard=" + standard + ", studentList=" + studentList
				+ ", subjectlist=" + subjectlist + ", teacher=" + teacherlist + "]";
	}

	public Integer getClassID() {
		return classID;
	}

	public void setClassID(Integer classID) {
		this.classID = classID;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Subject> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List<Subject> subjectlist) {
		this.subjectlist = subjectlist;
	}

	public List<Teacher> getTeacherlist() {
		return teacherlist;
	}

	public void setTeacherlist(List<Teacher> teacherlist) {
		this.teacherlist = teacherlist;
	}

}
