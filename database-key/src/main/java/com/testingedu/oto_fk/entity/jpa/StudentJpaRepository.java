package com.testingedu.oto_fk.entity.jpa;

import com.testingedu.oto_fk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by boxfish on 17/1/9.
 */
public interface StudentJpaRepository extends JpaRepository<Student,Integer> ,MyStudentRepository{
}
