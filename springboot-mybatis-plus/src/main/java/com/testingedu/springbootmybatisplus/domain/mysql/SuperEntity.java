package com.testingedu.springbootmybatisplus.domain.mysql;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键Id ，这里故意演示注解可以无
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long tenantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
