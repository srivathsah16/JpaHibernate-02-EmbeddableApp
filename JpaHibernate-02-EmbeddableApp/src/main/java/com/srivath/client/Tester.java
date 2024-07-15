package com.srivath.client;

import com.srivath.dao.StudentDAO;
import com.srivath.dao.impl.StudentDAOImpl;
import com.srivath.entity.StudentCompositeKey;
import com.srivath.entity.StudentEntity;

public class Tester {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAOImpl();
		StudentCompositeKey compositeKey = new StudentCompositeKey(102, "B");
		StudentEntity student = new StudentEntity(compositeKey, "Mick", 300);
//		dao.saveStudent(student);

//		System.out.println(dao.fetchStudent(compositeKey));

//		dao.updateStudent(compositeKey, 500);

		dao.deleteStudent(compositeKey);
	}
}
