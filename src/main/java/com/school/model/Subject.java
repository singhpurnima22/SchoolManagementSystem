package com.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "subjectinfo")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subId;
	private String subName;
	
	@ManyToOne
	@JoinColumn(name="classID")
	private Classes classobj;

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Classes getClassobj() {
		return classobj;
	}

	public void setClassobj(Classes classobj) {
		this.classobj = classobj;
	}
	
	
	
}
