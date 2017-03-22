package edu.springbootprofiles.model;

import edu.springbootprofiles.model.autoparts.Engine;
import edu.springbootprofiles.model.autoparts.Wheel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Wheel wheel;
    private Engine engine;

    public Car(){
        wheel = null;
        engine = null;
    }
    @Autowired
    public Car(Wheel wheel, Engine engine){
        this.engine = engine;
        this.wheel = wheel;
    }

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine(){
        return this.engine;
    }

   @Autowired
    public void setWheel(Wheel wheel) {
       this.wheel = wheel;

    }
public Wheel getWheel(){return this.wheel;}

    @Override
    public String toString(){
        String result = "Car:" + "\n" +
                "Wheels: " + wheel.toString() + "\n" +
                "Engine: " + engine.toString() + "\n";
        return result;
    }
}
