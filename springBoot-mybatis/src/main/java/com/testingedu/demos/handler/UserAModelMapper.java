package com.testingedu.demos.handler;


import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserAModelMapper {
    Map selectByPrimaryKey(int size);
}
