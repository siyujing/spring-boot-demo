package com.testingedu.demos.conf_mongo;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MultipleMongoProperties {

    private MongoProperties primary;
    private MongoProperties secondary;
}
