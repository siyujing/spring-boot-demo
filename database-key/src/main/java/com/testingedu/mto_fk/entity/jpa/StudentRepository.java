package com.testingedu.mto_fk.entity.jpa;

import com.testingedu.mto_fk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
