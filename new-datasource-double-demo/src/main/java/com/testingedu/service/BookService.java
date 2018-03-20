package com.testingedu.service;

import com.testingedu.domain_cloud.CloudBookEntity;
import com.testingedu.domain_cloud.CloudBookRepository;
import com.testingedu.domain_local.LocalBookEntity;
import com.testingedu.domain_local.LocalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    CloudBookRepository cloudBookRepository;

    @Autowired
    LocalBookRepository localBookRepository;

    public void saveAndGetOne(){
        System.out.println("--------------------");
        CloudBookEntity cloudBookEntity = new CloudBookEntity("testOne1");
        cloudBookRepository.save(cloudBookEntity);
        System.out.println("result1="+cloudBookRepository.findByName("testOne1"));

        LocalBookEntity localBookEntity = new LocalBookEntity("testOne2");
        localBookRepository.save(localBookEntity);
        List<LocalBookEntity> testOne2 = localBookRepository.findByName("testOne2");
        System.out.println("result2="+ testOne2.get(0));
    }
}
