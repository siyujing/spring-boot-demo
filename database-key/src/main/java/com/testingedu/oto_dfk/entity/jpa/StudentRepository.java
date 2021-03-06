package com.testingedu.oto_dfk.entity.jpa;

import com.testingedu.oto_dfk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by boxfish on 17/1/9.
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByName(String studentname);
}
