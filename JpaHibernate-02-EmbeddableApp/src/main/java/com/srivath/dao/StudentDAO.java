package com.srivath.dao;

import com.srivath.entity.StudentCompositeKey;
import com.srivath.entity.StudentEntity;

public interface StudentDAO {
	void saveStudent(StudentEntity student);

	StudentEntity fetchStudent(StudentCompositeKey compositeKey);

	StudentEntity updateStudent(StudentCompositeKey compositeKey, Integer new_marks);
	
	void deleteStudent(StudentCompositeKey compositeKey);
}
