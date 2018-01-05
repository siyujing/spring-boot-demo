package com.testingedu.mtm_dfk.entity.jpa;


import com.testingedu.mtm_dfk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
