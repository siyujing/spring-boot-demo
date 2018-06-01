package com.testingedu.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.testingedu.springbootmybatisplus.domain.mysql.DemoInfo;
import com.testingedu.springbootmybatisplus.mapper.DemoInfoMapper;
import com.testingedu.springbootmybatisplus.service.IDemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DemoInfoServiceImpl extends ServiceImpl<DemoInfoMapper,DemoInfo> implements IDemoInfoService {
    @Autowired
    private DemoInfoMapper demoInfoMapper;

    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    public List<DemoInfo> selectListBySql() {
//        baseMapper.deleteAll();
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.setName("xx");
        demoInfo.setState(true);
        demoInfo.setPwd("pp");
        demoInfo.insertOrUpdate();

        return baseMapper.selectListBySql();
    }

}
