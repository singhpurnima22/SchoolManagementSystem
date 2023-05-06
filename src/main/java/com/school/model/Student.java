package com.school.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "studentinfo")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name="classID")
	private Classes classobj;
		
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	public Classes getClassobj() {
		return classobj;
	}
	public void setClassobj(Classes classobj) {
		this.classobj = classobj;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}

	
	
	
}
