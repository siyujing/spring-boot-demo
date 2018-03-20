package com.testingedu.domain_local;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalBookRepository extends JpaRepository<LocalBookEntity,Long>{
    List<LocalBookEntity> findByName(String name);
}
