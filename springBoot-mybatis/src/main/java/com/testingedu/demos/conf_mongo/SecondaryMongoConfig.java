package com.testingedu.demos.conf_mongo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.testingedu.demos.handler.mongo_secondary",
        mongoTemplateRef = "secondaryMongoTemplate")
public class SecondaryMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Bean(name = "secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate() {
        System.out.println("mongo="+mongoProperties.getSecondary().getUsername());

        return new MongoTemplate(secondaryMongodbFactory(mongoProperties.getSecondary()));
    }

    @Bean
    public MongoDbFactory secondaryMongodbFactory(MongoProperties mongo) {
        MongoClient mongoClient = new MongoClient(mongo.getHost(), mongo.getPort());

        return new SimpleMongoDbFactory(mongoClient, mongo.getDatabase());
    }
}
