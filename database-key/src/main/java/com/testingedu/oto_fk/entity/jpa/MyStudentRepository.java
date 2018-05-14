package com.testingedu.oto_fk.entity.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "MyStudentRepository")
public interface MyStudentRepository {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student WHERE id=?1",nativeQuery = true)
    int deleteByStudentId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "update student set sname = ?1 where id = ?2",nativeQuery = true)
    int updateByStudentId(String sname, Integer id);

    //hql
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Student s WHERE s.sname =:sname")
    int deleteBySname(@Param("sname") String sname);


}
