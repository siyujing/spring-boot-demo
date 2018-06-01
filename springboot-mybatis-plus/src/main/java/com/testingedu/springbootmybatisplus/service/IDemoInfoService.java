package com.testingedu.springbootmybatisplus.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.testingedu.springbootmybatisplus.domain.mysql.DemoInfo;

import java.util.List;

public interface IDemoInfoService extends IService<DemoInfo> {

    boolean deleteAll();

    List<DemoInfo> selectListBySql();

    Page<DemoInfo> selectDemoInfoPage(Integer pageNum, Integer size);
}
