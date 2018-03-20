package com.testingedu.mto_fk.entity.jpa;

import com.testingedu.mto_fk.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
}
