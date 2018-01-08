package com.testingedu.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Created by boxfish on 17/9/13.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "localEntityManagerFactory",transactionManagerRef = "localTransactionManager",basePackages = {"com.testingedu.domain_local"})
public class LocalRepositoryConfig {


    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier(value = "localBebaseDataSource")
    private DataSource dataSource;

    @Bean(name = "localEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dataSource)
                .properties(jpaProperties.getHibernateProperties(dataSource))
                .packages("com.testingedu.domain_local")
                .persistenceUnit("myPersistenceUnit")
                .build();
    }

    @Bean(name = "localTransactionManager")
    @Primary
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
