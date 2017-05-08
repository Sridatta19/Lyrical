package com.example.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by sridattap on 08/05/17.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "graphdemo";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(System.getenv("MONGOHQ_URL")));
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.example";
    }
}

