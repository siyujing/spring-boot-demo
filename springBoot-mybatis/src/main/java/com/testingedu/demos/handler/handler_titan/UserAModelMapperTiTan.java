package com.testingedu.demos.handler.handler_titan;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface UserAModelMapperTiTan {
    Map selectByPrimaryKey(int size);
    Integer saveOne();
    List<HashMap> selectAll();
}
