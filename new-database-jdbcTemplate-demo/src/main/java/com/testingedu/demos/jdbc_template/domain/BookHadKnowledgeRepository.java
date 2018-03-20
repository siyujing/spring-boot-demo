package com.testingedu.demos.jdbc_template.domain;


import org.springframework.data.jpa.repository.JpaRepository;

// 默认使用主数据源
public interface BookHadKnowledgeRepository extends JpaRepository<BookHadKnowledgeEntity,Long> {
}
