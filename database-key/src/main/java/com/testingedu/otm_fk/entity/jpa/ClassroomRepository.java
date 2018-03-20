package com.testingedu.otm_fk.entity.jpa;

import com.testingedu.otm_fk.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by boxfish on 17/1/9.
 */
public interface ClassroomRepository extends JpaRepository<Classroom,Integer>{
}
