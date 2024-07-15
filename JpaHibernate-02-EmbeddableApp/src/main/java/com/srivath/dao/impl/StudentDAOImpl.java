package com.srivath.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.srivath.dao.StudentDAO;
import com.srivath.entity.StudentCompositeKey;
import com.srivath.entity.StudentEntity;

public class StudentDAOImpl implements StudentDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public void saveStudent(StudentEntity student) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(student);
			transaction.commit();
			System.out.println("Student Obj persisted in db...");
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Error while saving student obj.." + e);
		} finally {
			manager.close();
		}
	}

	@Override
	public StudentEntity fetchStudent(StudentCompositeKey compositeKey) {
		EntityManager manager = factory.createEntityManager();
		StudentEntity student = manager.find(StudentEntity.class, compositeKey);
		manager.close();
		return student;
	}

	@Override
	public StudentEntity updateStudent(StudentCompositeKey compositeKey, Integer new_marks) {
		EntityManager manager = factory.createEntityManager();
		StudentEntity student = manager.find(StudentEntity.class, compositeKey);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		student.setMarks(new_marks);
		transaction.commit();
		System.out.println("Student update in db...");
		manager.close();
		return student;
	}

	@Override
	public void deleteStudent(StudentCompositeKey compositeKey) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		StudentEntity student = manager.find(StudentEntity.class, compositeKey);
		transaction.begin();
		try {
			manager.remove(student);
			transaction.commit();
			System.out.println("Student deleted from db...");
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Error while deleting student from db..." + e);
		} finally {
			manager.close();
		}
	}
}
