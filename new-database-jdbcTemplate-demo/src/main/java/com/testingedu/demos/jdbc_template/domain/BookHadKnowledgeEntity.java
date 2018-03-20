package com.testingedu.demos.jdbc_template.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_had_knowledge")
public class BookHadKnowledgeEntity {
    @Id
    @GeneratedValue
    Long id;

    String lesson;

    @Column(name = "national_knowledge",unique = true)
    String nativeKnowledge;
}
