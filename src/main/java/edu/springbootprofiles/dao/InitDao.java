package edu.springbootprofiles.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


public class InitDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void initDataBase() {
        this.jdbcTemplate.execute("DROP TABLE Car IF EXISTS;" +
                " DROP TABLE Engine IF EXISTS;" +
                " DROP TABLE Wheel IF EXISTS;" +
                " DROP TABLE Tyres IF EXISTS;");
        this.jdbcTemplate.execute("create table Car (" +
                "id_car INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " id_eng INT," +
                " id_wheel INT);");
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Engine (" +
                "id_eng INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " eng_type VARCHAR (25)," +
                " eng_cap INT);");
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Tyres (" +
                "id_tyres INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                " tyres_size INT," +
                " tyres_name VARCHAR (25));");
        this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Wheel (" +
                "id_wheel INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "id_tyres INT);");
    }

}
