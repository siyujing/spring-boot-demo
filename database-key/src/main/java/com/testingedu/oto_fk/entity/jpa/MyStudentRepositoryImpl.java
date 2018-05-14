package com.testingedu.oto_fk.entity.jpa;

import org.springframework.data.repository.query.Param;

public class MyStudentRepositoryImpl implements MyStudentRepository {
    @Override
    public int deleteBySname(@Param("sname")String sname) {
        return 0;
    }

    @Override
    public int deleteByStudentId(Integer id) {
        return 0;
    }

    @Override
    public int updateByStudentId(String sname, Integer id) {
        return 0;
    }
}
