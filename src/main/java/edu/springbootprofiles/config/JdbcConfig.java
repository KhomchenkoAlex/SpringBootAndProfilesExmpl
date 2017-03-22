package edu.springbootprofiles.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import edu.springbootprofiles.dao.CarDao;
import edu.springbootprofiles.dao.InitDao;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.yml")
public class JdbcConfig {

   @Value("${driverclassname}")
    private String driverClassName;

   @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    @Profile("develop")
    public DataSource devDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    @Profile("production")
    public DataSource prodDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    @Profile("develop")
    public JdbcTemplate devJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(devDataSource());
        return jdbcTemplate;
    }

    @Bean
    @Profile("production")
    public JdbcTemplate prdJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(prodDataSource());
        return jdbcTemplate;
    }

    @Bean
    @Profile("develop")
    public PlatformTransactionManager devTxManager() {
        return new DataSourceTransactionManager(devDataSource());
    }

    @Bean
    @Profile("production")
    public PlatformTransactionManager prodTxManager() {
        return new DataSourceTransactionManager(prodDataSource());
    }

    @Bean
    public CarDao CarService(){
        return new CarDao();
    }

    @Bean
    public InitDao InitService(){ return new InitDao(); }
}
