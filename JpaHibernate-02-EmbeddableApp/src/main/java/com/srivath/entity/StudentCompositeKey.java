package com.srivath.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCompositeKey implements Serializable {
	@Column(name = "rollNo")
	private Integer rollNumber;
	@Column(name = "section")
	private String section;

	public StudentCompositeKey() {
	}

	public StudentCompositeKey(Integer rollNumber, String section) {
		this.rollNumber = rollNumber;
		this.section = section;
	}

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "StudentCompositeKey [rollNumber=" + rollNumber + ", section=" + section + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
