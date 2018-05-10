package com.testingedu.demos.handler.handler_ds2;


import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserAModelMapperDs2 {
    Map selectByPrimaryKey(int size);
}
