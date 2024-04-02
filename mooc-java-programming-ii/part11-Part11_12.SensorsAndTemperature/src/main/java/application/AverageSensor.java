package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author misfit
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> averages;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.averages = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return this.sensors.stream()
                .allMatch(sensor -> sensor.isOn());
    }

    @Override
    public void setOn() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream()
                .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("The sensor is off.");
        }

        if (this.sensors.isEmpty()) {
            throw new IllegalStateException("There are no sensors.");
        }

        int sum = 0;
        for (Sensor sensor: this.sensors) {
            sum += sensor.read();
        }
        
        int average = sum / this.sensors.size();
        this.averages.add(average);
        return average;
    }

    public List<Integer> readings() {
        return this.averages;
    }

}
