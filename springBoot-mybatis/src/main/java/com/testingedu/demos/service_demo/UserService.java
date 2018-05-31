package com.testingedu.demos.service_demo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.testingedu.demos.handler.handler_ds2.UserAModelMapperDs2;
import com.testingedu.demos.handler.handler_titan.UserAModelMapperTiTan;
import com.testingedu.demos.page.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserAModelMapperDs2 userAModelMapperDs2;

    @Autowired
    private UserAModelMapperTiTan userAModelMapperTiTanTiTan;

//    @Ds("DS2")
    public void getName1(){
        Map map = userAModelMapperDs2.selectByPrimaryKey(1);
        String name = (String) map.get("name");
        log.info("name = "+ name);
    }
//    @Ds("TITANMASTER")
    public void getName2(){
        Map map = userAModelMapperTiTanTiTan.selectByPrimaryKey(1);
        String name = (String) map.get("name");
        log.info("name = "+ name);
    }

    @Transactional
    public void getName3Trans(){
        Integer map = userAModelMapperTiTanTiTan.saveOne();
        log.info("name = "+ map);
    }

    public PageInfo selectAll(BaseEntity.Range range) {
        if (range.getPage() != null && range.getRows() != null) {
            PageHelper.startPage(range.getPage() + 1, range.getRows(), "state");
        }
        List<HashMap> list = userAModelMapperTiTanTiTan.selectAll();
        PageInfo page = new PageInfo(list);
        return page;
    }


}
