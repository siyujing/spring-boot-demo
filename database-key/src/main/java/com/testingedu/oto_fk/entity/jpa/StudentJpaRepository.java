package com.testingedu.oto_fk.entity.jpa;

import com.testingedu.oto_fk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student,Integer> ,MyStudentRepository{
}
