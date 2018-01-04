package com.testingedu.mtm_dfk.entity.jpa;

import com.testingedu.mtm_dfk.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
