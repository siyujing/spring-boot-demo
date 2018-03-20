package com.testingedu.oto_fk.entity.jpa;

import org.springframework.data.repository.query.Param;

/**
 * Created by boxfish on 17/1/12.
 */
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
