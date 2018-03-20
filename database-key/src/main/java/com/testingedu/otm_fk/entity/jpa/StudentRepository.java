package com.testingedu.otm_fk.entity.jpa;

import com.testingedu.otm_fk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by boxfish on 17/1/9.
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
