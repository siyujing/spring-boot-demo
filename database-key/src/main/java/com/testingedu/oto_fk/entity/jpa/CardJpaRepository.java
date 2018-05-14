package com.testingedu.oto_fk.entity.jpa;

import com.testingedu.oto_fk.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJpaRepository extends JpaRepository<Card,Integer>{
}
