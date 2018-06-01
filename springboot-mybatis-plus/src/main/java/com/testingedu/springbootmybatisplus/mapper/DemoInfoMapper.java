package com.testingedu.springbootmybatisplus.mapper;


import com.baomidou.mybatisplus.annotations.SqlParser;
import com.testingedu.springbootmybatisplus.domain.mysql.DemoInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface DemoInfoMapper extends SuperMapper<DemoInfo> {
    Map selectByPrimaryKey(int size);
    Integer saveOne();
    List<HashMap> selectAll();

    /**
     * 自定义注入方法（mybatis plus）
     * */
    int deleteAll();

    /**
     * 注解
     * */
    @SqlParser(filter = true)
    @Select("select * from demo_info")
    List<DemoInfo> selectListBySql();
}
