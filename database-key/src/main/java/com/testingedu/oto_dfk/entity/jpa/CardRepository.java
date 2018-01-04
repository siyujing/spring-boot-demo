package com.testingedu.oto_dfk.entity.jpa;

import com.testingedu.oto_dfk.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by boxfish on 17/1/9.
 */
public interface CardRepository extends JpaRepository<Card,Integer>{
}
