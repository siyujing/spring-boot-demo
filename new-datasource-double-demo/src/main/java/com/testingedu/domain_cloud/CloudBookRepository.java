package com.testingedu.domain_cloud;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by boxfish on 18/1/5.
 */
public interface CloudBookRepository extends JpaRepository<CloudBookEntity,Long>{
    List<CloudBookEntity> findByName(String name);
}
