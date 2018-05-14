package com.testingedu.otm_fk.entity.jpa;

import com.testingedu.otm_fk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {
}
