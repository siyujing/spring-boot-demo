package com.testingedu.domain_third;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThirdBookRepository extends JpaRepository<ThirdBookEntity,Long>{
    List<ThirdBookEntity> findByName(String name);
}
