package com.code.jpr14;

import com.zaxxer.hikari.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class Config {
    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/CityDB");
        config.setUsername("postgres");
        config.setPassword("159753");
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        hikariDataSource.setIdleTimeout(60000);
        hikariDataSource.setConnectionTimeout(60000);
        hikariDataSource.setValidationTimeout(3000);
        hikariDataSource.setMaxLifetime(60000);
        return hikariDataSource;
    }
    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean factoryBean(DataSource
                                                       dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new
                LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        sessionFactoryBean.setPackagesToScan("com.code.jpr14");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",
                "org.hibernate.dialect.PostgreSQL95Dialect");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }
    @Bean
    public PlatformTransactionManager
    platformTransactionManager(LocalSessionFactoryBean factoryBean){
        HibernateTransactionManager transactionManager = new
                HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }

}