package edu.springbootprofiles;

import edu.springbootprofiles.model.Car;
import edu.springbootprofiles.dao.CarDao;
import edu.springbootprofiles.dao.InitDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);
        InitDao initDao = context.getBean(InitDao.class);
        initDao.initDataBase();
        Car car = context.getBean(Car.class);
        CarDao event = context.getBean(CarDao.class);
        event.addCar(car);
        System.out.println(event.getCarByID(1).toString());
    }
}
