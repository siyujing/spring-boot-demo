package com.testingedu.springbootmybatisplus.domain.mysql;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键Id ，这里故意演示注解可以无
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

//    private Long tenantId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
