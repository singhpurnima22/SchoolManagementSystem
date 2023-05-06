package com.school.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacherinfo")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tID;
	private String teacherName;
	private Integer experience;

	@ManyToMany
	@JoinTable(name = "Teacher_Classes", joinColumns = { @JoinColumn(name = "tID") }, inverseJoinColumns = {
			@JoinColumn(name = "classID") })
	private List<Classes> classobj;

	@Override
	public String toString() {
		return "Teacher [tID=" + tID + ", teacherName=" + teacherName + ", experience=" + experience + "]";
	}

	public Integer gettID() {
		return tID;
	}

	public void settID(Integer tID) {
		this.tID = tID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public List<Classes> getClassobj() {
		return classobj;
	}

	public void setClassobj(List<Classes> classobj) {
		this.classobj = classobj;
	}

}
