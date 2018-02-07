package br.com.correios.spring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories(basePackages = "br.com.correios.realize.repository", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@Configuration
@EnableTransactionManagement
@EnableScheduling
public class PersistenceConfig {

    @Value("${usuario}")
    private String user;

    @Value("${pw}")
    private String pw;

    @Value("${url}")
    private String url;

    @Value("${max.connection.pool.size}")
    private Integer numeroMaximoDeConexoes;

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setPackagesToScan("br.com.correios.realize.model","br.com.correios.realize.converter");
        lcemfb.setPersistenceProvider(new HibernatePersistenceProvider());
        lcemfb.setPersistenceUnitName("realize");
//		lcemfb.setPersistenceXmlLocation("classpath:META-INF/spring-persistence.xml");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(vendorAdapter);
        lcemfb.setJpaProperties(additionalProperties());
        lcemfb.setDataSource(dataSource());
        return lcemfb;
    }

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        //hikariConfig.setDataSourceClassName("oracle.jdbc.pool.OracleDataSource");
        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(user);
        hikariConfig.setPassword(pw);

        hikariConfig.setMaximumPoolSize(numeroMaximoDeConexoes);
        hikariConfig.setConnectionTestQuery("select * from dual");
        hikariConfig.setPoolName("springHikariCP");

        hikariConfig.addDataSourceProperty("driverType", "thin");
        hikariConfig.addDataSourceProperty("portNumber", 1521);
        hikariConfig.addDataSourceProperty("url", url);

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;

//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("org.h2.Driver");
//        hikariConfig.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE");
//        hikariConfig.setUsername("sa");
//        hikariConfig.setPassword("sa");
//        hikariConfig.setConnectionTestQuery("SELECT * from dual");
//        hikariConfig.setPoolName("springHikariCP");
//        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//        return dataSource;
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(emf().getObject());
        tm.setDataSource(dataSource());
        return tm;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }

}
