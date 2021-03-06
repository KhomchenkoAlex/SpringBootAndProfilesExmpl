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
import edu.springbootprofiles.util.InitDao;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.yml")
@Profile("develop")
public class JdbcConfig {

   @Value("${driverclassname}")
    private String driverClassName;

   @Value("${url}")
    private String url;

    //@Value("${username}")
    private String username = "root";

    //@Value("${password}")
    private String password = "root";

    @Bean
    public DataSource devDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate devJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(devDataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager devTxManager() {
        return new DataSourceTransactionManager(devDataSource());
    }

    @Bean
    public CarDao CarService(){
        return new CarDao();
    }

    @Bean
    public InitDao InitService(){ return new InitDao(); }
}
