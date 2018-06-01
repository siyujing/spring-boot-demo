package com.testingedu.springbootmybatisplus.domain.mysql;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import lombok.Data;


@Data
@TableName("demo_info")
public class DemoInfo extends SuperEntity<DemoInfo>{

    @TableField(condition = SqlCondition.LIKE)
    private String name;

//    @TableField(fill = INSERT.INSERT)
    private boolean state;
    private String pwd;
}
