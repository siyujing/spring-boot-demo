package com.testingedu.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "thirdEntityManagerFactory",transactionManagerRef = "thirdTransactionManager",basePackages = {"com.testingedu.domain_third"})
public class ThirdRepositoryConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("thirdTestDataSource")
    private DataSource dataSource;


    @Bean(name = "thirdEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource)
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .packages("com.testingedu.domain_third")
                .persistenceUnit("thirdPersistenceUnit")
                .build();
    }

    @Bean(name = "thirdTransactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
