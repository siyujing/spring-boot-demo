package com.testingedu.domain_cloud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudBookRepository extends JpaRepository<CloudBookEntity,Long>{
    List<CloudBookEntity> findByName(String name);
}
