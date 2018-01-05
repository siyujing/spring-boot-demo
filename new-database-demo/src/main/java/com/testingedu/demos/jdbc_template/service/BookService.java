package com.testingedu.demos.jdbc_template.service;

import com.google.common.collect.Lists;
import com.testingedu.demos.jdbc_template.domain.BookHadKnowledgeEntity;
import com.testingedu.demos.jdbc_template.domain.BookHadKnowledgeRepository;
import com.testingedu.demos.jdbc_template.handler.BookHadKnowledgeHandler;
import com.testingedu.demos.utils.FormatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BookService {
    @Autowired
    BookHadKnowledgeRepository bookHadKnowledgeRepository;

    @Autowired
    BookHadKnowledgeHandler bookHadKnowledgeHandler;

    public void getBookSectionLabel() {
        List<BookHadKnowledgeHandler.BookHadKnowledgeResponse> all = bookHadKnowledgeHandler.findAll();
        System.out.println(all);
        System.out.println(all.size());

        List<BookHadKnowledgeEntity> result = new ArrayList<>();
//        Map<String, List<BookHadKnowledgeHandler.BookHadKnowledgeResponse>> map = all.stream().collect(Collectors.groupingBy(BookHadKnowledgeHandler.BookHadKnowledgeResponse::getNativeKnowledge));

        Map<String, List<String>> newMap = new HashMap<>();
        all.forEach(br ->{
            if (CollectionUtils.isEmpty(newMap.get(br.getNativeKnowledge()))){
                newMap.put(br.getNativeKnowledge(), Lists.newArrayList());
            }
            newMap.get(br.getNativeKnowledge()).add(br.getLesson());

        });

        newMap.forEach((knowledge, lessons) -> {
            try {
                BookHadKnowledgeEntity bookHadKnowledgeEntity = new BookHadKnowledgeEntity();
                bookHadKnowledgeEntity.setNativeKnowledge(knowledge);
                bookHadKnowledgeEntity.setLesson(FormatUtils.toJsonNoException(lessons));
                result.add(bookHadKnowledgeEntity);
                log.info("add one to list success [{}]", bookHadKnowledgeEntity);
            }catch (Exception e){
                log.error("add one to list fail [{}]",knowledge);
            }
        });
        bookHadKnowledgeRepository.save(result);
        log.info("save all success [{}]",result.size());

    }
}
